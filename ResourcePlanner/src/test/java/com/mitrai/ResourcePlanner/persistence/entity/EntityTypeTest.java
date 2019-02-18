package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.config.DBTestProfileJPAConfig;
import com.mitrai.ResourcePlanner.service.EntityTypeService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EntityTypeTest {

    @Autowired
    private EntityTypeService entityTypeService;

    @Test
    public void createEntityType(){
        EntityType entityType= new EntityType();
        entityType.setLabel("project");
        entityTypeService.save(entityType);
    }

}