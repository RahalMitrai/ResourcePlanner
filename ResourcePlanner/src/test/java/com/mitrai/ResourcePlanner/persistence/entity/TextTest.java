package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TextTest {

    @Autowired
    private TextService textService;

    @Autowired
    private EntityTypeService entityTypeService;

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private ProjectService projectService;

    @Test
    public void createText(){
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
        Text text=new Text();
        text.setAttribute(attribute);
        System.out.println("project ID : "+projectId);
        text.setEntityId(projectId);
        text.setValue("dineth@mitrai.com");
        textService.save(text);
    }

}