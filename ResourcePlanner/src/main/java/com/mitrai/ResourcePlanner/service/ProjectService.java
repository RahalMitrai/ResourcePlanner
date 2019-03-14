package com.mitrai.ResourcePlanner.service;

import com.mitrai.ResourcePlanner.api.model.ProjectEntityModel;
import com.mitrai.ResourcePlanner.api.model.ProjectModel;
import com.mitrai.ResourcePlanner.persistence.entity.Project;
import org.springframework.stereotype.Service;


import java.util.List;

public interface ProjectService {

    String save(ProjectModel projectModel);

    Project update(ProjectModel projectModel);

    void delete(String id);

    List<ProjectEntityModel> findAll();
}
