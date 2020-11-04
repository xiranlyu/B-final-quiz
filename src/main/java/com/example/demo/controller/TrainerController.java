package com.example.demo.controller;

// TODO GTB-工程实践: - 未使用的import应删除
import com.example.demo.model.Trainee;
import com.example.demo.model.Trainer;
import com.example.demo.service.TraineeService;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// TODO GTB-知识点: - 这里的@Validated注解可以省略
@Validated
@RestController
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> getUngroupedTrainers(@RequestParam(name = "grouped") boolean groupCheck) {
        return trainerService.getUngroupedTrainers(groupCheck);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer addTrainer(@RequestBody @Valid Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @DeleteMapping("/{trainer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable Long trainer_id) {
        trainerService.deleteTrainer(trainer_id);
    }
}