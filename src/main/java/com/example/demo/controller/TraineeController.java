package com.example.demo.controller;

import com.example.demo.model.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/trainees")
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping
    public List<Trainee> getUngroupedTrainees(@RequestParam(name = "grouped") boolean groupCheck) {
        return traineeService.getUngroupedTrainees(groupCheck);
    }

    @PostMapping
    public Trainee addTrainee(@RequestBody @Valid Trainee trainee) {
        return traineeService.addTrainee(trainee);
    }

}
