package com.project1.CandidateAndPositionManagementSystem.service;


import com.project1.CandidateAndPositionManagementSystem.dto.PositionCreateRequest;
import com.project1.CandidateAndPositionManagementSystem.entity.Position;

import java.util.List;

public interface PositionService {
    Position create(PositionCreateRequest request);
    List<Position> getAll();
    Position getById(Long id);
    void delete(Long id);
}

