package com.project1.CandidateAndPositionManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PositionCreateRequest {
    @NotBlank(message = "position must not be blank..")
    @Size(max = 50)
    private String positionName;
}
