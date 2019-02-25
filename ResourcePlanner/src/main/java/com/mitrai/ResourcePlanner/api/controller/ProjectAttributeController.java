package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectAttributeDTO;
import com.mitrai.ResourcePlanner.api.dto.Response;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projectAttribute")
public class ProjectAttributeController {

    @Autowired
    private ProjectAttributeService projectAttributeService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody ProjectAttributeDTO projectAttributeDTO){
        ProjectAttribute projectAttribute=convertToEntity(projectAttributeDTO);
        projectAttributeService.save(projectAttribute);
        Response response=new Response();
        response.setMessage("Sucessfully created project attribute");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") long id){
        Optional<ProjectAttribute> projectAttribute=projectAttributeService.findById(id);
        if(!projectAttribute.isPresent()){
            Response response=new Response();
            response.setMessage("project attribute does not exist");
            return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
        }
        projectAttributeService.delete(id);
        Response response=new Response();
        response.setMessage("Sucessfully created project attribute");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProjectAttribute> getAllProjectsAttribute(){
        List<ProjectAttribute> projectAttributes=projectAttributeService.findAll();
        return projectAttributes;
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") long id,@RequestBody ProjectAttributeDTO projectAttributeDTO){
        ProjectAttribute projectAttribute=convertToEntity(projectAttributeDTO);
        Optional<ProjectAttribute> projectAttributeExist=projectAttributeService.findById(id);
        if(!projectAttributeExist.isPresent()){
            Response response=new Response();
            response.setMessage("project attribute does not exist");
            return new ResponseEntity<>("Project attribute does not exist",HttpStatus.NOT_ACCEPTABLE);
        }
        projectAttribute.setId(id);
        projectAttributeService.save(projectAttribute);
        Response response=new Response();
        response.setMessage("Sucessfully updated project attribute");
        return new ResponseEntity<>("Sucessfully updated project attribute",HttpStatus.CREATED);
    }

    private ProjectAttribute convertToEntity(ProjectAttributeDTO projectAttributeDTO){
        ProjectAttribute projectAttribute=modelMapper.map(projectAttributeDTO,ProjectAttribute.class);
        return projectAttribute;
    }
}
