package com.example.demo.controller;

import com.example.demo.model.Group;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/groups")

public class GroupController {
    private final GroupService groupService;

    public GroupController (GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
}