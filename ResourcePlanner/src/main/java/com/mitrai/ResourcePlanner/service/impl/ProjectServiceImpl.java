package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.api.model.AttributeValueModel;
import com.mitrai.ResourcePlanner.api.model.ProjectEntityModel;
import com.mitrai.ResourcePlanner.api.model.ProjectModel;
import com.mitrai.ResourcePlanner.exception.ProjectAttributeNotFoundException;
import com.mitrai.ResourcePlanner.exception.ProjectNotFoundException;
import com.mitrai.ResourcePlanner.persistence.entity.Project;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttributeValue;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeValueRepository;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectAttributeValueRepository projectAttributeValueRepository;



    @Autowired
    private ProjectAttributeRepository projectAttributeRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    @Transactional
    public String save(ProjectModel projectModel) {
        List<AttributeValueModel> attributes=projectModel.getAttributesValues();
        ProjectEntityModel projectEntityModel =projectModel.getProjectEntity();
        Project project=modelMapper.map(projectEntityModel,Project.class);


        Project projectSaved=projectRepository.save(project);
        for(AttributeValueModel attribute:attributes){
            ProjectAttribute projectAttribute= isAttributeExist(attribute.getId());
            ProjectAttributeValue projectAttributeValue=new ProjectAttributeValue(projectSaved.getId(),projectAttribute.getId(),attribute.getValue());
            projectAttributeValueRepository.save(projectAttributeValue);
        }

        return projectSaved.getId();
    }

    @Override
    @Transactional
    public Project update(ProjectModel projectModel){

        List<AttributeValueModel> attributes=projectModel.getAttributesValues();
        ProjectEntityModel projectEntityModel =projectModel.getProjectEntity();
        Project project=modelMapper.map(projectEntityModel,Project.class);


        Project project1=isProjectExist(project.getId());
        project.setId(project1.getId());
        Project projectSaved=projectRepository.save(project);
        for(AttributeValueModel attribute:attributes){
            ProjectAttribute projectAttribute= isAttributeExist(attribute.getId());
            ProjectAttributeValue projectAttributeValue=new ProjectAttributeValue(project1.getId(),projectAttribute.getId(),attribute.getValue());
            projectAttributeValueRepository.save(projectAttributeValue);
        }

        return projectSaved;
    }

    @Transactional
    public void delete(String id){
        Project project = projectRepository.findById(id);
        if(project==null){
            throw new ProjectNotFoundException("Project does not exist by id"+id,10);
        }
        projectRepository.deleteById(project.getId());

    }

    @Override
    public List<ProjectEntityModel> findAll() {
        List<Project> projects= (List<Project>) projectRepository.findAll();
        Type prjectEntityModelListType=new TypeToken<List<ProjectEntityModel>>(){}.getType();
        List<ProjectEntityModel> projectEntityModels= modelMapper.map(projects,prjectEntityModelListType);
        return projectEntityModels;
    }

    private ProjectAttribute isAttributeExist(String id){
        ProjectAttribute projectAttribute=projectAttributeRepository.findById(id);

        if(projectAttribute==null){
            throw new ProjectAttributeNotFoundException("Attribute id : "+id+"not exist",10);

        }
        return projectAttribute;
    }

    private Project isProjectExist(String id){
        Project project=projectRepository.findById(id);
        if(project==null){
            throw new ProjectAttributeNotFoundException("Attribute id : "+id+"not exist",10);
        }
        return project;
    }


}
