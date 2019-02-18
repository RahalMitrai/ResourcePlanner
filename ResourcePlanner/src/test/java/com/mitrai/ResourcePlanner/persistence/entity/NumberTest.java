package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.service.AttributeService;
import com.mitrai.ResourcePlanner.service.EntityTypeService;
import com.mitrai.ResourcePlanner.service.NumberService;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mitrai.ResourcePlanner.persistence.entity.Number;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NumberTest {

    @Autowired
    private NumberService numberService;

    @Autowired
    private EntityTypeService entityTypeService;

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private ProjectService projectService;

    @Test
    public void createNumber(){
        Attribute attribute=new Attribute();
        attribute.setDefaultValue("NULL");
        attribute.setLabel("email");
        EntityType entityType=new EntityType();
        entityType.setLabel("abc");
        entityTypeService.save(entityType);
        attribute.setEntityType(entityType);
        attributeService.save(attribute);
        Project project=new Project();
        project.setTitle("Kipstor");
        Project projectSaved=projectService.save(project);
        long projectId= projectSaved.getId();
        Number number=new Number();
        number.setAttribute(attribute);
        number.setEntityId(projectId);
        number.setValue(100);
        numberService.save(number);
    }

}