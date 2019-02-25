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
        projectAttribute.setDataType(DataType.VARCHAR);
        ProjectAttribute projectAttributeSaved= projectAttributeService.save(projectAttribute);
        Assert.assertSame(projectAttribute,projectAttributeSaved);
        long projectAttributeId=projectAttributeSaved.getId();


        ProjectVarchar projectVarchar=new ProjectVarchar();
        projectVarchar.setValue("dineth@gmail.com");
        ProjectVarchar projectVarcharSaved=projectVarcharService.save(projectVarchar);
        Assert.assertSame(projectVarchar.getValue(),projectVarcharSaved.getValue());
    }

    @Test
    public void createProjectWithValues(){

        ProjectAttribute projectAttribute1=new ProjectAttribute();
        projectAttribute1.setDataType(DataType.VARCHAR);
        projectAttribute1.setLabel("firstName");
        projectAttribute1.setDefaultValue(null);

        ProjectAttribute projectAttribute2=new ProjectAttribute();
        projectAttribute2.setDataType(DataType.VARCHAR);
        projectAttribute2.setLabel("lastName");
        projectAttribute2.setDefaultValue(null);

        ProjectAttribute projectAttribute3=new ProjectAttribute();
        projectAttribute3.setDataType(DataType.VARCHAR);
        projectAttribute3.setLabel("email");
        projectAttribute3.setDefaultValue(null);

        ProjectVarchar projectVarchar1=new ProjectVarchar();
        projectVarchar1.setValue("abc");

        ProjectVarchar projectVarchar2=new ProjectVarchar();
        projectVarchar2.setValue("bcd");

        ProjectVarchar projectVarchar3=new ProjectVarchar();
        projectVarchar3.setValue("test3@gmail.com");

        Set<ProjectVarchar> projectVarchars=new HashSet<>();
        projectVarchars.add(projectVarchar1);
        projectVarchars.add(projectVarchar2);
        projectVarchars.add(projectVarchar3);

        ProjectAttribute projectAttribute=new ProjectAttribute();


        Project project = new Project();
        project.setTitle("christies");
        projectService.save(project);


    }

}