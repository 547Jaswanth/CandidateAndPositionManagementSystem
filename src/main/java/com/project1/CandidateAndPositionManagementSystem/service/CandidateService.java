package com.project1.CandidateAndPositionManagementSystem.service;

import com.project1.CandidateAndPositionManagementSystem.dto.CandidateCreateRequest;
import com.project1.CandidateAndPositionManagementSystem.dto.CandidateUpdateRequest;
import com.project1.CandidateAndPositionManagementSystem.entity.Candidate;

public interface CandidateService {
    Candidate create(CandidateCreateRequest request);
    Candidate update(Long id, CandidateUpdateRequest request);
}
