package com.example.demo.controller;

import com.example.demo.model.Trainee;
import com.example.demo.model.Trainer;
import com.example.demo.service.TraineeService;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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