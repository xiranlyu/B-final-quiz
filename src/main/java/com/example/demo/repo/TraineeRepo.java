package com.example.demo.repo;

import com.example.demo.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepo extends JpaRepository<Trainee, Long> {
    List<Trainee> findAllByGrouped(Boolean grouped);
}
