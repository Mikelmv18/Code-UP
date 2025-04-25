package com.platform.code_up.controllers;

import com.platform.code_up.dtos.AchievementDto;
import com.platform.code_up.entities.Achievement;
import com.platform.code_up.exceptions.AchievementNotFoundException;
import com.platform.code_up.services.AchievementService;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievements")
@CrossOrigin(origins = "http://localhost:8081")
public class AchievementController {

    private final AchievementService achievementService;


    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAchievement(@RequestBody AchievementDto achievementDto) {
        Achievement achievement = achievementService.createAchievement(achievementDto);
        return ResponseEntity.ok(achievement);
    }

    @GetMapping("/")
    public ResponseEntity<List<Achievement>> getAllAchievements() {

        List<Achievement> achievements = achievementService.listAllAchievements();

        return ResponseEntity.ok(achievements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AchievementDto> getAchievementById(@PathVariable Integer id) throws AchievementNotFoundException {

        Achievement achievement = achievementService.getById(id);

        return ResponseEntity.ok(new AchievementDto(achievement.getType(),
                achievement.getName(),achievement.getIcon()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AchievementDto> updateAchievement(@PathVariable Integer id,
                                                            @RequestBody AchievementDto achievementDto) throws AchievementNotFoundException {
        AchievementDto achievementDto1 = achievementService.updateAchievement(id,achievementDto);

        return ResponseEntity.ok(achievementDto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAchievement(@PathVariable Integer id) throws AchievementNotFoundException {
        achievementService.deleteAchievement(id);
        return ResponseEntity.ok().body("Achievement deleted");
    }


}
