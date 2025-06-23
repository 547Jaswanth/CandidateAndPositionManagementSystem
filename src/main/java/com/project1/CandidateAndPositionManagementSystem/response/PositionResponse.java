package com.project1.CandidateAndPositionManagementSystem.response;

import org.springframework.http.ResponseEntity;

public class PositionResponse {
    private Long id;
    private String positionName;

    public PositionResponse() {
    }

    public PositionResponse(Long id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

}
