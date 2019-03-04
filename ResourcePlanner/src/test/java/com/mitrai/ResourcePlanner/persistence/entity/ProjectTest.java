package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.model.Attribute;
import com.mitrai.ResourcePlanner.model.ProjectModel;
import com.mitrai.ResourcePlanner.service.ProjectAttributeService;
import com.mitrai.ResourcePlanner.service.ProjectAttributeValueService;
import com.mitrai.ResourcePlanner.service.ProjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectTest {

   /* @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectAttributeService projectAttributeService;

    @Autowired
    private ProjectAttributeValueService projectAttributeValueService;

    @Test
    public void createProject(){
        try {
            Project project = new Project();
            project.setTitle("Kipstor");


            ProjectAttribute projectAttribute1=new ProjectAttribute();
            projectAttribute1.setLabel("attribute_label1");
            projectAttribute1.setDefaultValue("default_val1");
            projectAttribute1.setDataType(DataType.VARCHAR);
            String refId1=UUID.randomUUID().toString();
            projectAttribute1.setRefId(refId1);
            ProjectAttribute projectAttribute1Saved=projectAttributeService.save(projectAttribute1);
            String attribute1Refd=projectAttribute1Saved.getRefId();

            ProjectAttribute projectAttribute2=new ProjectAttribute();
            projectAttribute2.setLabel("attribute_label1");
            projectAttribute2.setDefaultValue("default_val1");
            projectAttribute2.setDataType(DataType.VARCHAR);
            String refId2=UUID.randomUUID().toString();
            projectAttribute2.setRefId(refId2);
            ProjectAttribute projectAttribute2Saved=projectAttributeService.save(projectAttribute2);
            String attribute2Refd=projectAttribute2Saved.getRefId();

            ProjectAttribute projectAttribute3=new ProjectAttribute();
            projectAttribute3.setLabel("attribute_label1");
            projectAttribute3.setDefaultValue("1");
            projectAttribute3.setDataType(DataType.NUMBER);
            String refId3=UUID.randomUUID().toString();
            projectAttribute3.setRefId(refId3);
            ProjectAttribute projectAttribute3Saved=projectAttributeService.save(projectAttribute3);
            String attribute3Refd=projectAttribute3Saved.getRefId();

            ProjectAttribute projectAttribute4=new ProjectAttribute();
            projectAttribute4.setLabel("attribute_label1");
            projectAttribute4.setDefaultValue("2015-01-01");
            projectAttribute4.setDataType(DataType.DATE);
            String refId4=UUID.randomUUID().toString();
            projectAttribute4.setRefId(refId4);
            ProjectAttribute projectAttribute4Saved=projectAttributeService.save(projectAttribute4);
            String attribute4Refd=projectAttribute4Saved.getRefId();

            Attribute attribute1=new Attribute(attribute1Refd,"value1BDCF");
            Attribute attribute2=new Attribute(attribute2Refd,"value2BCDF");
            Attribute attribute3=new Attribute(attribute3Refd,"10099");
            Attribute attribute4=new Attribute(attribute4Refd,"2015-01-31");

            ArrayList<Attribute> attributes=new ArrayList<>();
            attributes.add(attribute1);
            attributes.add(attribute2);
            attributes.add(attribute3);
            attributes.add(attribute4);

            ProjectModel projectModel=new ProjectModel(project,attributes);


            Project project1=projectService.save(projectModel);
            Assert.assertSame(project,project1);


        }catch(Exception e){
            System.out.println(e);
        }
    }*/
}