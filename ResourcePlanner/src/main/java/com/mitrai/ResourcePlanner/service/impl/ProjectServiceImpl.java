package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.Project;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectRepository;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project){
       return projectRepository.save(project);
    }
}
