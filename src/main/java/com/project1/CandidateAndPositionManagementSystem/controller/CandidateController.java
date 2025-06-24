package com.project1.CandidateAndPositionManagementSystem.controller;

import com.project1.CandidateAndPositionManagementSystem.dto.CandidateCreateRequest;
import com.project1.CandidateAndPositionManagementSystem.dto.CandidateUpdateRequest;
import com.project1.CandidateAndPositionManagementSystem.entity.Candidate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project1.CandidateAndPositionManagementSystem.service.CandidateService;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping
    public ResponseEntity<Candidate> create(@RequestBody @Valid CandidateCreateRequest request) {
        return new ResponseEntity<>(candidateService.create(request), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Candidate> update(@PathVariable Long id, @RequestBody @Valid CandidateUpdateRequest request) {
        return ResponseEntity.ok(candidateService.update(id, request));
    }
    @GetMapping("/getAllCandidates")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }
}
