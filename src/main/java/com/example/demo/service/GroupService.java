package com.example.demo.service;

import com.example.demo.exception.GroupingException;
import com.example.demo.model.Group;
import com.example.demo.model.Trainee;
import com.example.demo.model.Trainer;
import com.example.demo.repo.GroupRepo;
import com.example.demo.repo.TraineeRepo;
import com.example.demo.repo.TrainerRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepo groupRepo;
    private final TraineeRepo traineeRepo;
    private final TrainerRepo trainerRepo;

    public GroupService(GroupRepo groupRepo, TraineeRepo traineeRepo, TrainerRepo trainerRepo) {
        this.groupRepo = groupRepo;
        this.traineeRepo = traineeRepo;
        this.trainerRepo = trainerRepo;
    }

    public List<Group> getAllGroups() {
        return groupRepo.findAll();
    }

    public List<Group> autoGrouping() {
        if (trainerRepo.findAll().size() < 2) {
            throw new GroupingException("Trainers are not enough for grouping!");
        }

        List<Trainee> traineeList = traineeRepo.findAll();
        List<Trainer> trainerList = trainerRepo.findAll();

        Collections.shuffle(trainerList);
        Collections.shuffle(traineeList);

        List<Group> groupList = new ArrayList<>();

        for (int i = 1; i <= trainerList.size()/2; i++) {
            groupList.add(Group.builder().name("Group " + i)
                            .trainersList(new ArrayList<>())
                            .traineesList(new ArrayList<>())
                            .build());
        }

        for (int i = 0; i < traineeList.size(); i++) {
            List<Trainee> traineeList1 = groupList.get(i % groupList.size()).getTraineesList();
            traineeList1.add(traineeList.get(i));
            groupList.get(i % groupList.size()).setTraineesList(traineeList1);
        }

        if (trainerList.size() % 2 == 1) {
            trainerList.remove(0);
        }

        for (int i = 0; i < trainerList.size(); i++) {
            List<Trainer> trainerList1 = groupList.get(i % groupList.size()).getTrainersList();
            trainerList1.add(trainerList.get(i));
            groupList.get(i % groupList.size()).setTrainersList(trainerList1);
        }

        groupRepo.saveAll(groupList);

        return groupRepo.findAll();
    }
}
