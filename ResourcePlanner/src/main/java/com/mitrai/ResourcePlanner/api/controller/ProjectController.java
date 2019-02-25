package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectDTO;
import com.mitrai.ResourcePlanner.api.dto.Response;
import com.mitrai.ResourcePlanner.model.ProjectModel;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody ProjectDTO projectDTO) throws Exception {
        ProjectModel projectModel=modelMapper.map(projectDTO,ProjectModel.class);
        projectService.add(projectModel);
        Response response=new Response();
        response.setMessage("Sucessfully created project with attributes");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") String id) throws Exception{
        projectService.delete(id);
        Response response=new Response();
        response.setMessage("Sucessfully deleted project");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }



}
