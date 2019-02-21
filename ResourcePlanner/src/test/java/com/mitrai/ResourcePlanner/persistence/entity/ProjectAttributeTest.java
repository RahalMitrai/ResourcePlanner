package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectAttributeTest {

    @Autowired
    private ProjectAttributeService projectAttributeService;

    @Test
    public void createProjectAttribute(){
        ProjectAttribute projectAttribute=new ProjectAttribute();
        projectAttribute.setLabel("email");
        projectAttribute.setDefaultValue("default@gmail.com");
        projectAttribute.setType("varchar");
        ProjectAttribute projectAttributeSaved=projectAttributeService.save(projectAttribute);
        Assert.assertSame(projectAttribute,projectAttributeSaved);
    }



}