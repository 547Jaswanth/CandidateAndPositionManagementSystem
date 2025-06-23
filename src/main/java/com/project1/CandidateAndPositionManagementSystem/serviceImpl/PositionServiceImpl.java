package com.project1.CandidateAndPositionManagementSystem.serviceImpl;

import com.project1.CandidateAndPositionManagementSystem.dto.PositionCreateRequest;
import com.project1.CandidateAndPositionManagementSystem.entity.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.project1.CandidateAndPositionManagementSystem.repositories.CandidateRepository;
import com.project1.CandidateAndPositionManagementSystem.repositories.PositionRepository;
import com.project1.CandidateAndPositionManagementSystem.service.PositionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final CandidateRepository candidateRepository;

    @Override
    public Position create(PositionCreateRequest request) {
        if (positionRepository.findByPositionName(request.getPositionName()).isPresent()) {
            throw new IllegalArgumentException("Position already exists");
        }
        return positionRepository.save(new Position(null, request.getPositionName()));
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position getById(Long id) {
        return positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Position not found"));
    }

    @Override
    public void delete(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position not found"));
        boolean isUsed = candidateRepository.findAll().stream()
                .anyMatch(c -> c.getPositions().contains(position));
        if (isUsed) {
            throw new IllegalStateException("Cannot delete position linked to candidates");
        }
        positionRepository.deleteById(id);
    }
}
