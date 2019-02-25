package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.model.ProjectModel;
import com.mitrai.ResourcePlanner.persistence.entity.Project;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectNumber;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectVarchar;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectNumberRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectVarcharRepository;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectVarcharRepository projectVarcharRepository;

    @Autowired
    private ProjectNumberRepository projectNumberRepository;

    @Autowired
    private ProjectAttributeRepository projectAttributeRepository;


    @Transactional
    public Project add(ProjectModel projectModel) throws Exception {

        Project project=new Project();
        project.setTitle(projectModel.getTitle());
        project.setRefId(UUID.randomUUID().toString());
        Project projectSaved=projectRepository.save(project);
        long projectId=projectSaved.getId();



        if(!projectModel.getVarcharAttributes().isEmpty()){
            addProjectVarcharAttributes(projectId,projectModel.getVarcharAttributes());
        }
        if(!projectModel.getNumberAttributes().isEmpty()){
           addProjectNumberAttributes(projectId,projectModel.getNumberAttributes());
        }
        /*if(!projectModel.getDateAttributes().isEmpty()){

        }*/
        return project;

    }

    @Transactional
    public void delete(String id) throws Exception{
        Project project = projectRepository.findByRefId(id);
        if(project==null){
            throw new Exception("Project does not exist by id");
        }
        projectRepository.deleteById(project.getId());

    }

    private ProjectAttribute validateAttributeKey(String id) throws Exception {
        ProjectAttribute projectAttribute=projectAttributeRepository.findByRefId(id);

        if(projectAttribute!=null){
            return projectAttribute;
        }

         throw new Exception("Attribute id : "+id+"not exist");
    }


    private Set<ProjectVarchar> addProjectVarcharAttributes(long projectId,Map<String,String> projectValues) throws Exception {
        Set<ProjectVarchar> projectVarcharSet=null;
        for(Map.Entry<String,String> entry:projectValues.entrySet()){
            ProjectAttribute projectAttribute=validateAttributeKey(entry.getKey());
            if(projectAttribute!=null) {
                ProjectVarchar projectVarchar = new ProjectVarchar();
                projectVarchar.setValue(entry.getValue());
                projectVarchar.setProjectId(projectId);
                projectVarchar.setProjectAttributeId(projectAttribute.getId());
                projectVarcharRepository.save(projectVarchar);
            }
        }
        return projectVarcharSet;
    }

    private Set<ProjectNumber> addProjectNumberAttributes(long projectId,Map<String,String> projectValues) throws Exception {
        Set<ProjectNumber> projectNumberSet = null;
        for(Map.Entry<String,String> entry:projectValues.entrySet()){
            ProjectAttribute projectAttribute=validateAttributeKey(entry.getKey());
            if(projectAttribute!=null) {
                ProjectNumber projectNumber = new ProjectNumber();
                projectNumber.setValue(Integer.parseInt(entry.getValue()));
                projectNumber.setProjectId(projectId);
                projectNumber.setProjectAttributeId(projectAttribute.getId());
                projectNumberRepository.save(projectNumber);
            }
        }
        return projectNumberSet;
    }
}
