package com.mitrai.ResourcePlanner.api.controller;


import com.mitrai.ResourcePlanner.persistence.entity.Attribute;
import com.mitrai.ResourcePlanner.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "attribute/save", method=RequestMethod.POST)
    public Attribute save(Attribute attribute){
        return attributeService.save(attribute);
    }
}
