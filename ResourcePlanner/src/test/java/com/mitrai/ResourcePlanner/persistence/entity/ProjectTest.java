package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void createProject(){
    Project project=new Project();
    project.setTitle("Kipstor");
    projectService.save(project);
    }

}