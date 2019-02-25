package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectDTO;
import com.mitrai.ResourcePlanner.persistence.entity.Project;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectVarchar;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method=RequestMethod.POST)
    public String add(@RequestBody ProjectDTO projectDTO){
        Project project=convertToProjectEntity(projectDTO);
        Set<ProjectVarchar> projectVarcharSet= convertToProjectVarcharEntity(projectDTO);

        return null;
    }



    private Project convertToProjectEntity(ProjectDTO projectDTO){
        Project project=modelMapper.map(projectDTO,Project.class);
        return project;
    }

    private Set<ProjectVarchar> convertToProjectVarcharEntity(ProjectDTO projectDTO){
        Set<ProjectVarchar> projectVarcharSet=null;
        Map<String,String> projectValues=projectDTO.getAttributes();
        for(Map.Entry<String,String> entry:projectValues.entrySet()){
            ProjectVarchar projectVarchar=new ProjectVarchar();
            projectVarchar.setValue(entry.getValue());
            projectVarcharSet.add(projectVarchar);
        }
    return projectVarcharSet;
    }

}
