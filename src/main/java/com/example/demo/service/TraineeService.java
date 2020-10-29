package com.example.demo.service;

import com.example.demo.model.Trainee;
import com.example.demo.repo.TraineeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {
    private final TraineeRepo traineeRepo;

    public TraineeService(TraineeRepo traineeRepo) {
        this.traineeRepo = traineeRepo;
    }

    public List<Trainee> getUngroupedTrainees(boolean groupCheck) {
        return traineeRepo.findAllByGrouped(groupCheck);
    }

    public Trainee addTrainee (Trainee trainee) {
        return traineeRepo.save(trainee);
    }

    public void deleteTrainee(Long id) {
        traineeRepo.deleteById(id);
    }
}
