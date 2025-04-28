package com.platform.code_up.controllers;

import com.platform.code_up.dtos.MilestoneDto;
import com.platform.code_up.entities.Milestone;
import com.platform.code_up.exceptions.MilestoneNotFoundException;
import com.platform.code_up.services.MilestoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestones")
@CrossOrigin(origins = "http://localhost:8081")
public class MilestoneController {

    private final MilestoneService service;

    public MilestoneController(MilestoneService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMilestone(@RequestBody MilestoneDto milestoneDto) {
        Milestone milestone = service.createMilestone(milestoneDto);
        return ResponseEntity.ok(milestone);
    }

    @GetMapping("/")
    public ResponseEntity<List<Milestone>> getAllMilestones() {
        List<Milestone> milestones = service.listAllMilestones();
        return ResponseEntity.ok(milestones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilestoneDto> getMilestoneById(@PathVariable Integer id) throws MilestoneNotFoundException {
        Milestone milestone = service.getMilestoneById(id);
        return ResponseEntity.ok(new MilestoneDto(milestone.getName(), milestone.getType(), milestone.getIcon()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MilestoneDto> updateMilestone(@PathVariable Integer id, @RequestBody MilestoneDto milestoneDto)
            throws MilestoneNotFoundException {
        MilestoneDto updated = service.updateMilestone(id, milestoneDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMilestone(@PathVariable Integer id) throws MilestoneNotFoundException {
        service.deleteMilestone(id);
        return ResponseEntity.ok("Milestone deleted");
    }
}
