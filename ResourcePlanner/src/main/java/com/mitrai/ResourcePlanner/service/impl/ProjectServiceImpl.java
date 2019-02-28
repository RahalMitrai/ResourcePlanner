package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.model.Attribute;
import com.mitrai.ResourcePlanner.model.ProjectModel;
import com.mitrai.ResourcePlanner.persistence.entity.CompositeProjectAttributeValueId;
import com.mitrai.ResourcePlanner.persistence.entity.Project;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttributeValue;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeValueRepository;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectAttributeValueRepository projectAttributeValueRepository;



    @Autowired
    private ProjectAttributeRepository projectAttributeRepository;


    @Override
    public Project save(ProjectModel projectModel) throws Exception {
        List<Attribute> attributes=projectModel.getAttributes();
        Project project =projectModel.getProject();
        project.setRefId(UUID.randomUUID().toString());
        Project projectSaved=projectRepository.save(project);
        for(Attribute attribute:attributes){
            ProjectAttribute projectAttribute= isAttributeExist(attribute.getRefId());
            ProjectAttributeValue projectAttributeValue=new ProjectAttributeValue(projectSaved.getId(),projectAttribute.getId(),attribute.getValue());
            projectAttributeValueRepository.save(projectAttributeValue);
        }
        return project;
    }

    @Override
    public Project update(ProjectModel projectModel) throws Exception {

        List<Attribute> attributes=projectModel.getAttributes();
        Project project =projectModel.getProject();

        Project project1=isProjectExist(project.getRefId());
        project.setId(project1.getId());
        Project projectSaved=projectRepository.save(project);
        for(Attribute attribute:attributes){
            ProjectAttribute projectAttribute= isAttributeExist(attribute.getRefId());
            ProjectAttributeValue projectAttributeValue=new ProjectAttributeValue(project1.getId(),projectAttribute.getId(),attribute.getValue());
            projectAttributeValueRepository.save(projectAttributeValue);
        }

        return projectSaved;
    }

    @Transactional
    public void delete(String id) throws Exception{
        Project project = projectRepository.findByRefId(id);
        if(project==null){
            throw new Exception("Project does not exist by id"+id);
        }
        projectRepository.deleteById(project.getId());

    }

    @Override
    public List<Project> findAll() {
        return (List<Project>) projectRepository.findAll();
    }

    private ProjectAttribute isAttributeExist(String id) throws Exception {
        ProjectAttribute projectAttribute=projectAttributeRepository.findByRefId(id);

        if(projectAttribute==null){
            throw new Exception("Project id : "+id+"not exist");

        }
        return projectAttribute;
    }

    private Project isProjectExist(String id) throws Exception{
        Project project=projectRepository.findByRefId(id);
        if(project==null){
            throw new Exception("Attribute id : "+id+"not exist");
        }
        return project;
    }


}
