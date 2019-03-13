package com.mitrai.ResourcePlanner.service;

import com.mitrai.ResourcePlanner.api.model.ProjectAttributeEntityModel;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectAttributeService {

    ProjectAttribute save(ProjectAttributeEntityModel projectAttribute);

    Optional<ProjectAttribute> findOneById(String id);

    List<ProjectAttributeEntityModel> findAll();

    ProjectAttribute findById(String id);

    void delete(String id);

    void update(ProjectAttributeEntityModel projectAttributeModel);
}
