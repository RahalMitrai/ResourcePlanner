package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import com.mitrai.ResourcePlanner.service.ProjectService;
import com.mitrai.ResourcePlanner.service.ProjectVarcharService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectVarcharTest {

    @Autowired
    private ProjectVarcharService projectVarcharService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectAttributeService projectAttributeService;

    @Test
    public void createProjectVarchar(){
        Project project=new Project();
        project.setTitle("LeapIn");
        Project projectSaved=projectService.save(project);
        Assert.assertSame(project,projectSaved);
        long projectId=projectSaved.getId();

        ProjectAttribute projectAttribute=new ProjectAttribute();
        projectAttribute.setLabel("region");
        projectAttribute.setDefaultValue("UK");
        projectAttribute.setType("varchar");
        ProjectAttribute projectAttributeSaved= projectAttributeService.save(projectAttribute);
        Assert.assertSame(projectAttribute,projectAttributeSaved);
        long projectAttributeId=projectAttributeSaved.getId();

        ProjectFieldValueIdentity projectFieldValueIdentity=new ProjectFieldValueIdentity(projectId,projectAttributeId);
        ProjectVarchar projectVarchar=new ProjectVarchar();
        projectVarchar.setValue("dineth@gmail.com");
        projectVarchar.setProjectFieldValueIdentity(projectFieldValueIdentity);
        ProjectVarchar projectVarcharSaved=projectVarcharService.save(projectVarchar);
        Assert.assertSame(projectVarchar.getValue(),projectVarcharSaved.getValue());
        ProjectFieldValueIdentity projectFieldValueIdentitySaved= projectVarchar.getProjectFieldValueIdentity();
        long projectSavedId = projectFieldValueIdentitySaved.getProjectId();
        long projectSavedAttributeId = projectFieldValueIdentitySaved.getProjectAttributeId();
        assertEquals(projectId,projectSavedId);
        assertEquals(projectAttributeId,projectSavedAttributeId);
    }

    @Test
    public void createProjectWithValues(){

        ProjectVarchar projectVarchar1=new ProjectVarchar();
        projectVarchar1.setValue("test1@gmail.com");
        ProjectVarchar projectVarchar2=new ProjectVarchar();
        projectVarchar2.setValue("test2@gmail.com");
        ProjectVarchar projectVarchar3=new ProjectVarchar();
        projectVarchar3.setValue("test3@gmail.com");

        Set<ProjectVarchar> projectVarchars=new HashSet<>();
        projectVarchars.add(projectVarchar1);
        projectVarchars.add(projectVarchar2);
        projectVarchars.add(projectVarchar3);

        Project project = new Project();
        project.setTitle("chrities");
        projectService.save(project);


    }

}