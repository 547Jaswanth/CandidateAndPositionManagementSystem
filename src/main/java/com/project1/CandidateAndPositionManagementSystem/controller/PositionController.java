package com.project1.CandidateAndPositionManagementSystem.controller;

import com.project1.CandidateAndPositionManagementSystem.dto.PositionCreateRequest;
import com.project1.CandidateAndPositionManagementSystem.entity.Position;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.project1.CandidateAndPositionManagementSystem.service.PositionService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PositionCreateRequest request, BindingResult result) {
        // If validation errors exist
        if (result.hasErrors()) {
            // Map to field: message format
            Map<String, String> errors = result.getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(
                            error -> error.getField(),
                            error -> error.getDefaultMessage()
                    ));

                    return ResponseEntity.badRequest().body(errors);
        }

        // If valid, save position
        Position savedPosition = positionService.create(request);
        return new ResponseEntity<>(savedPosition, HttpStatus.CREATED);    }

    @GetMapping
    public ResponseEntity<List<Position>> getAll() {
        return ResponseEntity.ok(positionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getById(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        positionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
