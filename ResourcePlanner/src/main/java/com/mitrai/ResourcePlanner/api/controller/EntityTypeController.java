package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.persistence.entity.EntityType;
import com.mitrai.ResourcePlanner.service.EntityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityTypeController {

    @Autowired
    private EntityTypeService entityTypeService;

    @RequestMapping(value = "save", method=RequestMethod.POST)
    public EntityType save(EntityType entityType){
        return entityTypeService.save(entityType);
    }
}
