package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.ProjectVarchar;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectVarcharRepository;
import com.mitrai.ResourcePlanner.service.ProjectVarcharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectVarcharServiceImpl implements ProjectVarcharService {

    @Autowired
    private ProjectVarcharRepository projectVarcharRepository;

    public ProjectVarchar save(ProjectVarchar varchar) {
        return projectVarcharRepository.save(varchar);
    }
}
