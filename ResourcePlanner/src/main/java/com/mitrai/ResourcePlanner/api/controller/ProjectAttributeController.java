package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectAttributeDTO;
import com.mitrai.ResourcePlanner.api.dto.Response;
import com.mitrai.ResourcePlanner.model.ProjectAttributeModel;
import com.mitrai.ResourcePlanner.persistence.entity.ProjectAttribute;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projectAttribute")
public class ProjectAttributeController {

    @Autowired
    private ProjectAttributeService projectAttributeService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody ProjectAttributeDTO projectAttributeDTO){
        ProjectAttribute projectAttribute=modelMapper.map(projectAttributeDTO,ProjectAttribute.class);
        projectAttributeService.save(projectAttribute);
        Response response=new Response();
        response.setMessage("Sucessfully created project attribute");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") String id) throws Exception {
        projectAttributeService.delete(id);
        Response response=new Response();
        response.setMessage("Sucessfully deleted project attribute");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProjectAttribute> getAllProjectsAttribute(){
        List<ProjectAttribute> projectAttributes=projectAttributeService.findAll();
        return projectAttributes;
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") String id,@RequestBody ProjectAttributeDTO projectAttributeDTO) throws Exception {
        ProjectAttributeModel projectAttributeModel=modelMapper.map(projectAttributeDTO,ProjectAttributeModel.class);
        projectAttributeService.update(id,projectAttributeModel);
        Response response=new Response();
        response.setMessage("Sucessfully updated project attribute");
        return new ResponseEntity<>("Sucessfully updated project attribute",HttpStatus.CREATED);
    }

}
