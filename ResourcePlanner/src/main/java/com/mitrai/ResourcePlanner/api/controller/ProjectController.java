package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectDTO;
import com.mitrai.ResourcePlanner.api.dto.Response;
import com.mitrai.ResourcePlanner.api.model.ProjectEntityModel;
import com.mitrai.ResourcePlanner.api.model.ProjectModel;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody @Valid ProjectDTO projectDTO){
        ProjectModel projectModel=modelMapper.map(projectDTO,ProjectModel.class);
        projectService.save(projectModel);
        Response response=new Response();
        response.setMessage("Sucessfully created project with attributes");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody ProjectDTO projectDTO){
        ProjectModel projectModel=modelMapper.map(projectDTO,ProjectModel.class);
        projectService.update(projectModel);
        Response response=new Response();
        response.setMessage("Sucessfully updated project with attributes");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") String id) throws Exception{
        projectService.delete(id);
        Response response=new Response();
        response.setMessage("Sucessfully deleted project");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Response> findAll(){
        List<ProjectEntityModel> projects=projectService.findAll();
        Response response=new Response();
        response.setMessage("project list");
        response.setData(projects);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }





}
