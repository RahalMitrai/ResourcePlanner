package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.api.model.AttributeValueModel;
import com.mitrai.ResourcePlanner.api.model.ProjectAttributeEntityModel;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectRepository;
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

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectAttributeRepository projectAttributeRepository;


    @Test
    public void createProject(){
        try {
          /*  Project project = new Project();
            project.setTitle("Kipstor");


            ProjectAttribute projectAttribute1=new ProjectAttribute();
            projectAttribute1.setLabel("attribute_label1");
            projectAttribute1.setDefaultValue("default_val1");
            projectAttribute1.setDataType(DataType.VARCHAR);
            ProjectAttribute projectAttribute1Saved=projectAttributeRepository.save(projectAttribute1);


            ProjectAttribute projectAttribute2=new ProjectAttribute();
            projectAttribute2.setLabel("attribute_label1");
            projectAttribute2.setDefaultValue("default_val1");
            projectAttribute2.setDataType(DataType.VARCHAR);
            ProjectAttribute projectAttribute2Saved=projectAttributeRepository.save(projectAttribute2);


            ProjectAttribute projectAttribute3=new ProjectAttribute();
            projectAttribute3.setLabel("attribute_label1");
            projectAttribute3.setDefaultValue("1");
            projectAttribute3.setDataType(DataType.NUMBER);
            ProjectAttribute projectAttribute3Saved=projectAttributeRepository.save(projectAttribute3);


            ProjectAttribute projectAttribute4=new ProjectAttribute();
            projectAttribute4.setLabel("attribute_label1");
            projectAttribute4.setDefaultValue("2015-01-01");
            projectAttribute4.setDataType(DataType.DATE);
            ProjectAttribute projectAttribute4Saved=projectAttributeRepository.save(projectAttribute4);


            ProjectAttributeValue attribute1=new ProjectAttributeValue("value1BDCF");
            ProjectAttributeValue attribute2=new ProjectAttributeValue("value2BCDF");
            ProjectAttributeValue attribute3=new ProjectAttributeValue("10099");
            ProjectAttributeValue attribute4=new ProjectAttributeValue("2015-01-31");

            ArrayList<ProjectAttributeValue> attributes=new ArrayList<>();
            attributes.add(attribute1);
            attributes.add(attribute2);
            attributes.add(attribute3);
            attributes.add(attribute4);


            project.setProjectAttributeValues(attributes);
            projectRepository.save(project);

*/

        }catch(Exception e){
            System.out.println(e);
        }
    }
}