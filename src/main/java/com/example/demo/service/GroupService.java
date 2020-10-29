package com.example.demo.service;

import com.example.demo.model.Group;
import com.example.demo.repo.GroupRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepo groupRepo;

    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    public List<Group> getAllGroups() {
        return groupRepo.findAll();
    }
}
