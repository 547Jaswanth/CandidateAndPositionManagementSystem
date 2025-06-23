package com.project1.CandidateAndPositionManagementSystem.serviceImpl;

import com.project1.CandidateAndPositionManagementSystem.dto.CandidateCreateRequest;
import com.project1.CandidateAndPositionManagementSystem.dto.CandidateUpdateRequest;
import com.project1.CandidateAndPositionManagementSystem.entity.Candidate;
import com.project1.CandidateAndPositionManagementSystem.entity.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.project1.CandidateAndPositionManagementSystem.repositories.CandidateRepository;
import com.project1.CandidateAndPositionManagementSystem.repositories.PositionRepository;
import com.project1.CandidateAndPositionManagementSystem.service.CandidateService;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    private final PositionRepository positionRepository;

    @Override
    public Candidate create(CandidateCreateRequest request) {
        if (candidateRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        int age = Period.between(request.getDob(), LocalDate.now()).getYears();
        if (age < 18) throw new IllegalArgumentException("Candidate age must be > 18 years");

        List<Position> positions = positionRepository.findAllById(request.getPositionIds());
        if (positions.size() != request.getPositionIds().size()) {
            throw new IllegalArgumentException("Invalid Position IDs found");
        }

        Candidate candidate = new Candidate(null, request.getName(), request.getEmail(), request.getDob(), positions);
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate update(Long id, CandidateUpdateRequest request) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        if (request.getName() != null) candidate.setName(request.getName());

        if (request.getEmail() != null && !request.getEmail().equals(candidate.getEmail())) {
            if (candidateRepository.existsByEmail(request.getEmail())) {
                throw new IllegalArgumentException("Email already in use");
            }
            candidate.setEmail(request.getEmail());
        }

        if (request.getDob() != null) {
            int age = Period.between(request.getDob(), LocalDate.now()).getYears();
            if (age < 18) throw new IllegalArgumentException("Candidate age must be > 18 years");
            candidate.setDob(request.getDob());
        }

        if (request.getPositionIds() != null) {
            List<Position> positions = positionRepository.findAllById(request.getPositionIds());
            candidate.setPositions(positions);
        }

        return candidateRepository.save(candidate);
    }
}

