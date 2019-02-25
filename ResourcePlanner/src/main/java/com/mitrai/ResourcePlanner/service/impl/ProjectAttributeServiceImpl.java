package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeRepository;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectAttributeServiceImpl implements ProjectAttributeService {

    @Autowired
    private ProjectAttributeRepository projectAttributeRepository;

    public ProjectAttribute save(ProjectAttribute projectAttribute) {
        return projectAttributeRepository.save(projectAttribute);
    }

    @Override
    public Optional<ProjectAttribute> findById(long id) {
      return projectAttributeRepository.findById(id);
    }

    @Override
    public List<ProjectAttribute> findAll() {
        return (List<ProjectAttribute>) projectAttributeRepository.findAll();
    }

    @Override
    public void delete(long id) {
        projectAttributeRepository.deleteById(id);
    }
}
