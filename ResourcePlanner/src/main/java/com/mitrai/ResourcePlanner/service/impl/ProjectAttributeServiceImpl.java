package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeRepository;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectAttributeServiceImpl implements ProjectAttributeService {

    @Autowired
    private ProjectAttributeRepository projectAttributeRepository;

    public ProjectAttribute save(ProjectAttribute projectAttribute) {
        return projectAttributeRepository.save(projectAttribute);
    }
}
