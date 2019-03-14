package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectDTO;
import com.mitrai.ResourcePlanner.api.model.AttributeValueModel;
import com.mitrai.ResourcePlanner.api.model.ProjectEntityModel;
import com.mitrai.ResourcePlanner.persistence.entity.Project;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectAttributeValueRepository;
import com.mitrai.ResourcePlanner.persistence.repository.ProjectRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class ProjectControllerTest extends ResourcePlannerServerBaseTestController{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectAttributeValueRepository projectAttributeValueRepository;

    @Before
    public void setUpData() {

        String insertProjectAttributeStatement = "INSERT INTO project_attribute(id,label,default_value,data_type) values" +
                "('aaaaaa-aaa-aaaa-aaaa-aaaaaaaa1','test name','test default1','VARCHAR')," +
                "('aaaaaa-aaa-aaaa-aaaa-aaaaaaaa2','test date','14-03-2019','DATE')," +
                "('aaaaaa-aaa-aaaa-aaaa-aaaaaaaa3','test count','167473','NUMBER')";

        String insertProjectStatement = "INSERT INTO project(id,title) values ('pppppp-ppp-ppppp-pppp-ppppppp1','sample project')";

        String insertProjectAttributeValue = "INSERT INTO project_attribute_value(project_attribute_id,value,project_id) values" +
                "('aaaaaa-aaa-aaaa-aaaa-aaaaaaaa1', 'dcb','pppppp-ppp-ppppp-pppp-ppppppp1')," +
                "('aaaaaa-aaa-aaaa-aaaa-aaaaaaaa2', '15-03-2019','pppppp-ppp-ppppp-pppp-ppppppp1')," +
                "('aaaaaa-aaa-aaaa-aaaa-aaaaaaaa3', '122312','pppppp-ppp-ppppp-pppp-ppppppp1')";

        //jdbcTemplate.execute(insertProjectAttributeStatement);
        //jdbcTemplate.execute(insertProjectStatement);
       // jdbcTemplate.execute(insertProjectAttributeValue);

    }

    @Test
    public void testAddProject() throws JSONException {
        String projectName="new_project5";
       ProjectDTO projectDTO=new ProjectDTO();
       ProjectEntityModel project = new ProjectEntityModel();
       project.setTitle(projectName);

       AttributeValueModel attribute1=new AttributeValueModel();
       attribute1.setId("aaaaaa-aaa-aaaa-aaaa-aaaaaaaa1");
       attribute1.setValue("kerty");

       AttributeValueModel attribute2=new AttributeValueModel();
       attribute2.setId("aaaaaa-aaa-aaaa-aaaa-aaaaaaaa2");
       attribute2.setValue("12-12-2012");

       AttributeValueModel attribute3=new AttributeValueModel();
       attribute3.setId("aaaaaa-aaa-aaaa-aaaa-aaaaaaaa3");
       attribute3.setValue("101");

       ArrayList<AttributeValueModel> attributes=new ArrayList<>();
       attributes.add(attribute1);
       attributes.add(attribute2);
       attributes.add(attribute3);


       projectDTO.setProjectEntity(project);
       projectDTO.setAttributesValues(attributes);

       httpHeaders.setContentType(MediaType.APPLICATION_JSON);
       HttpEntity<ProjectDTO> entity = new HttpEntity<>(projectDTO, httpHeaders);
       ResponseEntity<String> responseEntity=testRestTemplate.exchange(RESOURCE_PLANNER_SERVER_BASE_URL + "/project",HttpMethod.POST, entity, String.class);
       JSONObject jsonObj = new JSONObject(responseEntity.getBody());
       String createdProjectId=jsonObj.getString("id");
       Assert.assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
       Project project1=projectRepository.findById(createdProjectId);
       Assert.assertEquals(projectName,project1.getTitle());
        //ProjectAttributeValue projectAttributeValue=projectAttributeValueRepository.
   }


}