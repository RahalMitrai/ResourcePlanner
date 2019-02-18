package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.service.AttributeService;
import com.mitrai.ResourcePlanner.service.EntityTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AttributeTest {

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private EntityTypeService entityTypeService;

    @Test
    public void createAttribute(){
        Attribute attribute=new Attribute();
        attribute.setDefaultValue("NULL");
        attribute.setLabel("numberOfResources");

        EntityType entityType=new EntityType();
        entityType.setLabel("abc");
        entityTypeService.save(entityType);
        attribute.setEntityType(entityType);
        attributeService.save(attribute);
    }

}