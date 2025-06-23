package com.project1.CandidateAndPositionManagementSystem.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
public class CandidateUpdateRequest {
    private String name;
    private String email;
    private LocalDate dob;
    private List<Long> positionIds;
}
