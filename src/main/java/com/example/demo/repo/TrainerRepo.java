package com.example.demo.repo;

import com.example.demo.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Long> {
    List<Trainer> findAllByGrouped(Boolean grouped);
}
