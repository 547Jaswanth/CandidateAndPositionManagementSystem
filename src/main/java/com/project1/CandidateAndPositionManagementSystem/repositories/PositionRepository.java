package com.project1.CandidateAndPositionManagementSystem.repositories;

import com.project1.CandidateAndPositionManagementSystem.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> findByPositionName(String name);
}
