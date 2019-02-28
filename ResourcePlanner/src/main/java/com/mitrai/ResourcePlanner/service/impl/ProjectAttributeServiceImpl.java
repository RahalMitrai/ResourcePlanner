package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.model.ProjectAttributeModel;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeRepository;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectAttributeServiceImpl implements ProjectAttributeService {

    @Autowired
    private ProjectAttributeRepository projectAttributeRepository;

    public ProjectAttribute save(ProjectAttribute projectAttribute) {
        projectAttribute.setRefId(UUID.randomUUID().toString());
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
    public ProjectAttribute findByRefId(String refId) {
        return projectAttributeRepository.findByRefId(refId);
    }

    @Transactional
    public void delete(String refId) throws Exception {
        ProjectAttribute projectAttribute=projectAttributeRepository.findByRefId(refId);
        if(projectAttribute==null){
           throw new Exception("Project attribute does not exist");
        }
        projectAttributeRepository.deleteById(projectAttribute.getId());
    }

    @Transactional
    public void update(ProjectAttribute projectAttribute) throws Exception{
        ProjectAttribute projectAttributeExist=projectAttributeRepository.findByRefId(projectAttribute.getRefId());
        if(projectAttribute==null){
            throw new Exception("Project attribute does not exist");
        }
        projectAttributeExist.setDataType(projectAttribute.getDataType());
        projectAttributeExist.setDefaultValue(projectAttribute.getDefaultValue());
        projectAttributeExist.setLabel(projectAttribute.getLabel());
        projectAttributeRepository.save(projectAttribute);
    }
}
