package com.mitrai.ResourcePlanner.service;

import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;

import java.util.List;
import java.util.Optional;

public interface ProjectAttributeService {

    ProjectAttribute save(ProjectAttribute attribute);

    Optional<ProjectAttribute> findById(long id);

    List<ProjectAttribute> findAll();

    void delete(long id);
}
