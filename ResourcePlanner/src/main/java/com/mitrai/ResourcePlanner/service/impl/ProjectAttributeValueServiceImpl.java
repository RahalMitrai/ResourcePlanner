package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttributeValue;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeValueRepository;
import com.mitrai.ResourcePlanner.service.ProjectAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectAttributeValueServiceImpl implements ProjectAttributeValueService {

    @Autowired
    private ProjectAttributeValueRepository projectAttributeValueRepository;

    public ProjectAttributeValue save(ProjectAttributeValue projectAttributeValue) {
        return projectAttributeValueRepository.save(projectAttributeValue);
    }
}
