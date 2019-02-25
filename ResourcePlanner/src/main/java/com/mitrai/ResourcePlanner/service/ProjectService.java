package com.mitrai.ResourcePlanner.service;

import com.mitrai.ResourcePlanner.model.ProjectModel;
import com.mitrai.ResourcePlanner.persistence.entity.Project;

public interface ProjectService {

    Project add(ProjectModel projectModel) throws Exception;

    void delete(String refId) throws Exception;
}
