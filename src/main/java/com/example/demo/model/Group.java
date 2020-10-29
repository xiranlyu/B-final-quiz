package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private Long id;
    private String name;
    private List<Trainer> trainersList;
    private List<Trainee> traineesList;
}
