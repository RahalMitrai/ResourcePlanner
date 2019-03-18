package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.api.model.ProjectAttributeEntityModel;
import com.mitrai.ResourcePlanner.exception.ProjectAttributeNotFoundException;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeRepository;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectAttributeServiceImpl implements ProjectAttributeService {

    @Autowired
    private ProjectAttributeRepository projectAttributeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ProjectAttribute save(ProjectAttributeEntityModel projectAttributeEntityModel) {
        ProjectAttribute projectAttribute=modelMapper.map(projectAttributeEntityModel,ProjectAttribute.class);
        return projectAttributeRepository.save(projectAttribute);
    }

    @Override
    public Optional<ProjectAttribute> findOneById(String id) {
      return projectAttributeRepository.findOneById(id);
    }

    @Override
    public List<ProjectAttributeEntityModel> findAll() {
        List<ProjectAttribute> projectAttributelist= (List<ProjectAttribute>) projectAttributeRepository.findAll();
        Type projectEntityModelListType = new TypeToken<List<ProjectAttributeEntityModel>>(){}.getType();
        List<ProjectAttributeEntityModel> projectAttributeEntityModelList=modelMapper.map(projectAttributelist,projectEntityModelListType);
        return projectAttributeEntityModelList;
    }

    @Override
    public ProjectAttribute  findById(String id) {
        return projectAttributeRepository.findById(id);
    }

    @Transactional
    public void delete(String id) {
        ProjectAttribute projectAttribute=projectAttributeRepository.findById(id);
        if(projectAttribute==null){
           throw new ProjectAttributeNotFoundException("Project attribute does not exist");
        }
        projectAttributeRepository.deleteById(projectAttribute.getId());
    }

    @Transactional
    public void update(ProjectAttributeEntityModel projectAttributeModel){
        ProjectAttribute projectAttributeExist=projectAttributeRepository.findById(projectAttributeModel.getId());
        if(projectAttributeExist==null){
            throw new ProjectAttributeNotFoundException("Project attribute does not exist");
        }
        projectAttributeExist.setDataType(projectAttributeModel.getDataType());
        projectAttributeExist.setDefaultValue(projectAttributeModel.getDefaultValue());
        projectAttributeExist.setLabel(projectAttributeModel.getLabel());
        projectAttributeRepository.save(projectAttributeExist);
    }
}
