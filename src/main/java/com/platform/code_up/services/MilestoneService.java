package com.platform.code_up.services;

import com.platform.code_up.dtos.MilestoneDto;
import com.platform.code_up.entities.Milestone;
import com.platform.code_up.exceptions.MilestoneNotFoundException;
import com.platform.code_up.repositories.MilestoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneService {

    private final MilestoneRepository repo;

    public MilestoneService(MilestoneRepository repo) {
        this.repo = repo;
    }

    public Milestone createMilestone(MilestoneDto milestoneDto) {
        Milestone milestone = new Milestone();
        milestone.setName(milestoneDto.getName());
        milestone.setType(milestoneDto.getType());
        milestone.setIcon(milestoneDto.getIcon());
        return repo.save(milestone);
    }

    public List<Milestone> listAllMilestones() {
        return repo.findAll();
    }

    public Milestone getMilestoneById(Integer id) throws MilestoneNotFoundException {
        return repo.findById(id).orElseThrow(MilestoneNotFoundException::new);
    }

    public MilestoneDto updateMilestone(Integer id, MilestoneDto milestoneDto) throws MilestoneNotFoundException {
        Milestone milestone = repo.findById(id).orElseThrow(MilestoneNotFoundException::new);
        milestone.setName(milestoneDto.getName());
        milestone.setType(milestoneDto.getType());
        milestone.setIcon(milestoneDto.getIcon());
        repo.save(milestone);
        return new MilestoneDto(milestone.getName(), milestone.getType(), milestone.getIcon());
    }

    public void deleteMilestone(Integer id) throws MilestoneNotFoundException {
        Milestone milestone = repo.findById(id).orElseThrow(MilestoneNotFoundException::new);
        repo.delete(milestone);
    }
}
