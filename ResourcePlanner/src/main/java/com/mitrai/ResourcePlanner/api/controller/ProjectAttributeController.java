package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectAttributeDTO;
import com.mitrai.ResourcePlanner.api.dto.Response;
import com.mitrai.ResourcePlanner.api.model.ProjectAttributeEntityModel;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projectAttribute")
public class ProjectAttributeController {

    @Autowired
    private ProjectAttributeService projectAttributeService;

    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasAuthority('createProjectAttribute')")
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody ProjectAttributeDTO projectAttributeDTO){
        ProjectAttributeEntityModel projectAttribute=modelMapper.map(projectAttributeDTO,ProjectAttributeEntityModel.class);
        projectAttributeService.save(projectAttribute);
        Response response=new Response();
        response.setMessage("Sucessfully created project attribute");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") String  id) {
        projectAttributeService.delete(id);
        Response response=new Response();
        response.setMessage("Sucessfully deleted project attribute");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('readProjectAttribute')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Response>  getAllProjectsAttribute(){
        List<ProjectAttributeEntityModel> projectAttributes=projectAttributeService.findAll();
        Response response=new Response();
        response.setMessage("project attributes");
        response.setData( projectAttributes);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody ProjectAttributeDTO projectAttributeDTO) {
        ProjectAttributeEntityModel projectAttributeModel=modelMapper.map(projectAttributeDTO,ProjectAttributeEntityModel.class);
        projectAttributeService.update(projectAttributeModel);
        Response response=new Response();
        response.setMessage("Success fully updated project attribute");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

}
