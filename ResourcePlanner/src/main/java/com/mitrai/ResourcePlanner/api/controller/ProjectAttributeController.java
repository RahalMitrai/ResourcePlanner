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
        ProjectAttributeModel projectAttributeModel=modelMapper.map(projectAttributeDTO,ProjectAttributeModel.class);
        projectAttributeService.save(projectAttributeModel);
        Response response=new Response();
        response.setMessage("Sucessfully created project attribute");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") String id) {
        projectAttributeService.delete(id);
        Response response=new Response();
        response.setMessage("Sucessfully deleted project attribute");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Response>  getAllProjectsAttribute(){
        List<ProjectAttribute> projectAttributes=projectAttributeService.findAll();
        Response response=new Response();
        response.setMessage("project attributes");
        response.setData( projectAttributes);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody ProjectAttributeDTO projectAttributeDTO) {
        ProjectAttributeModel projectAttributeModel=modelMapper.map(projectAttributeDTO,ProjectAttributeModel.class);
        projectAttributeService.update(projectAttributeModel);
        Response response=new Response();
        response.setMessage("Success fully updated project attribute");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

}
