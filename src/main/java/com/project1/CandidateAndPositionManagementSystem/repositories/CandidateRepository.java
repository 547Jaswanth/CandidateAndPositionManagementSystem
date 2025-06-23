package com.project1.CandidateAndPositionManagementSystem.repositories;

import com.project1.CandidateAndPositionManagementSystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    boolean existsByEmail(String email);
}
