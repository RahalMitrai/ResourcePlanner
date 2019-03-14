package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectDTO;
import com.mitrai.ResourcePlanner.api.model.AttributeValueModel;
import com.mitrai.ResourcePlanner.api.model.ProjectEntityModel;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class ProjectControllerTest extends ResourcePlannerServerBaseTestController{


   @Test
   public void testAddProjectResponse(){

       ProjectDTO projectDTO=new ProjectDTO();
       ProjectEntityModel project = new ProjectEntityModel();
       project.setTitle("new_project4");

       AttributeValueModel attribute1=new AttributeValueModel();
       attribute1.setId("402888e4696df38a01696df398260000");
       attribute1.setValue("1000");

       AttributeValueModel attribute2=new AttributeValueModel();
       attribute2.setId("9f4c5793-6654-472d-b6c8-813ccf462ac1");
       attribute2.setValue("sample_value1");

       AttributeValueModel attribute3=new AttributeValueModel();
       attribute3.setId("a494d2bd-53ed-49b2-8699-ab757ad936c5");
       attribute3.setValue("sample_value2");

       ArrayList<AttributeValueModel> attributes=new ArrayList<>();
       attributes.add(attribute1);
       attributes.add(attribute2);
       attributes.add(attribute3);


       projectDTO.setProjectEntity(project);
       projectDTO.setAttributesValues(attributes);

       addProjectCall(projectDTO);

   }

    private ResponseEntity<String> addProjectCall(ProjectDTO projectDto) {
       httpHeaders.setContentType(MediaType.APPLICATION_JSON);
       HttpEntity<ProjectDTO> entity = new HttpEntity<>(projectDto, httpHeaders);
       return testRestTemplate.exchange(RESOURCE_PLANNER_SERVER_BASE_URL + "/project",HttpMethod.POST, entity, String.class);
    }

}