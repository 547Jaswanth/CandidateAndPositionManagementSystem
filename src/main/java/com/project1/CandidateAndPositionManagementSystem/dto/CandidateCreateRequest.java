package com.project1.CandidateAndPositionManagementSystem.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CandidateCreateRequest {
    @NotBlank(message = "name must not be blank..")
    @Size(max = 50)
    private String name;

    @NotBlank(message = "email must not be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "dob must not be empty")
    @Past
    private LocalDate dob;

    @NotEmpty
    private List<Long> positionIds;
}
