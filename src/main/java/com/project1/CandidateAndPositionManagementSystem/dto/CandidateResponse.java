package com.project1.CandidateAndPositionManagementSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.project1.CandidateAndPositionManagementSystem.response.PositionResponse;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private List<PositionResponse> positions;
}
