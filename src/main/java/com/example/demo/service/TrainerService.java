package com.example.demo.service;

import com.example.demo.model.Trainee;
import com.example.demo.model.Trainer;
import com.example.demo.repo.TraineeRepo;
import com.example.demo.repo.TrainerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    private final TrainerRepo trainerRepo;

    public TrainerService(TrainerRepo trainerRepo) {
        this.trainerRepo = trainerRepo;
    }

    public List<Trainer> getUngroupedTrainers(boolean groupCheck) {
        return trainerRepo.findAllByGrouped(groupCheck);
    }

    public Trainer addTrainer(Trainer trainer) {
        return trainerRepo.save(trainer);
    }

    public void deleteTrainer(Long id) {
        trainerRepo.deleteById(id);
    }
}