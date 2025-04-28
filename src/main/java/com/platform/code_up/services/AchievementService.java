package com.platform.code_up.services;

import com.platform.code_up.dtos.AchievementDto;
import com.platform.code_up.entities.Achievement;
import com.platform.code_up.exceptions.AchievementNotFoundException;
import com.platform.code_up.repositories.AchievementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchievementService {

    private final AchievementRepository achievementRepository;

    public AchievementService(AchievementRepository achievement) {
        this.achievementRepository = achievement;
    }


    public Achievement createAchievement(AchievementDto achievementDto) {

        Achievement achievement = new Achievement();

        achievement.setName(achievementDto.getName());
        achievement.setIcon(achievementDto.getIcon());
        achievement.setType(achievementDto.getType());

       return achievementRepository.save(achievement);

    }
    public List<Achievement> listAllAchievements() {

        List<Achievement> achievements = new ArrayList<>();

        achievementRepository.findAll().forEach(achievements::add);

        return achievements;
    }

    public Achievement getById(Integer id) throws AchievementNotFoundException {

        return achievementRepository.findById(id).orElseThrow(() ->
                new AchievementNotFoundException("Achievement not found"));
    }

    public AchievementDto updateAchievement(Integer id, AchievementDto achievement) throws AchievementNotFoundException {

        Achievement ach = achievementRepository.findById(id).orElseThrow(() ->
                new AchievementNotFoundException("Achievement not found"));

        ach.setName(achievement.getName());
        ach.setType(achievement.getType());
        ach.setIcon(achievement.getIcon());

        achievementRepository.save(ach);

        return new AchievementDto(ach.getType(),
                ach.getName(),ach.getIcon());
    }

    public void deleteAchievement(Integer id) throws AchievementNotFoundException {

        if(!achievementRepository.existsById(id)) {
            throw new AchievementNotFoundException("Achievement not found");
        }

        achievementRepository.deleteById(id);

    }
}
