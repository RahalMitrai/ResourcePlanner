package com.mitrai.ResourcePlanner.service;

import com.mitrai.ResourcePlanner.model.ProjectModel;
import com.mitrai.ResourcePlanner.persistence.entity.Project;
import org.springframework.stereotype.Service;


import java.util.List;

public interface ProjectService {

    Project save(ProjectModel projectModel);

    Project update(ProjectModel projectModel);

    void delete(String refId);

    List<Project> findAll();
}
