package com.mitrai.ResourcePlanner.service;

import com.mitrai.ResourcePlanner.model.ProjectAttributeModel;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;

import java.util.List;
import java.util.Optional;

public interface ProjectAttributeService {

    ProjectAttribute save(ProjectAttribute attribute);

    Optional<ProjectAttribute> findById(long id);

    List<ProjectAttribute> findAll();

    ProjectAttribute findByRefId(String refId);

    void delete(String refId) throws Exception;

    void update(String refId, ProjectAttributeModel projectAttributeModel) throws Exception;
}
