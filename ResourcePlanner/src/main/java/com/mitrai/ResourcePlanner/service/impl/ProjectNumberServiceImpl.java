package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.ProjectNumber;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectNumberRepository;
import com.mitrai.ResourcePlanner.service.ProjectNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectNumberServiceImpl implements ProjectNumberService {

    @Autowired
    private ProjectNumberRepository projectNumberRepository;

    public ProjectNumber save(ProjectNumber number){
        return projectNumberRepository.save(number);
    }
}
