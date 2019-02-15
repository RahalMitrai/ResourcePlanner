package com.mitrai.ResourcePlanner.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrai.ResourcePlanner.persistence.entity.Project;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository prjRepo;

	@RequestMapping(value = "projects")
    public Project emploeeList() {
        return prjRepo.findById(2L).get();
    }
}
