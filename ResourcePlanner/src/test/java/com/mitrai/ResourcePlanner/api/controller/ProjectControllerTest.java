package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ProjectDTO;
import com.mitrai.ResourcePlanner.api.model.AttributeValueModel;
import com.mitrai.ResourcePlanner.api.model.ProjectEntityModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import javax.annotation.Resource;

import java.util.ArrayList;




public class ProjectControllerTest extends ResourcePlannerServerBaseTestController{

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext context;

    private static ResponseEntity<String> response;



    @Before
    public void setUp(){
        this.mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
    }


   /* @Test
    public void addProject() throws Exception {
        JSONObject requestObject=getCreateProjectJsonBody();
        System.out.println(requestObject.toString());

        mockMvc.perform(post("project").content(requestObject.toString()).header("tenantId","tenantId1"))
                .andExpect(status().isCreated());


    }*/

   @Test
   public void testAddProjectResponse(){

       ProjectDTO projectDTO=new ProjectDTO();
       ProjectEntityModel project = new ProjectEntityModel();
       project.setTitle("abcde");

       AttributeValueModel attribute1=new AttributeValueModel();
       //attribute1.setId("0753bd97-925c-4c08-816d-9cbefbf340a7");
       attribute1.setValue("1000");

       AttributeValueModel attribute2=new AttributeValueModel();
       //attribute2.setRefId("38a82921-10aa-4e33-b6c9-8c2c9d6757e5");
       attribute2.setValue("sample_value1");

       AttributeValueModel attribute3=new AttributeValueModel();
       //attribute3.setRefId("cd760223-1d95-45f0-92c1-2f3e61880819");
       attribute3.setValue("sample_value2");
       projectDTO.setProjectEntity(project);
       ArrayList<AttributeValueModel> attributes=new ArrayList<>();
       attributes.add(attribute1);
       attributes.add(attribute2);
       projectDTO.setProjectEntity(project);
        response=addProjectCall(projectDTO);

   }


    private ResponseEntity<String> addProjectCall(ProjectDTO projectDto) {



       HttpEntity<ProjectDTO> entity = new HttpEntity<>(projectDto, httpHeaders);
       return testRestTemplate.exchange(RESOURCE_PLANNER_SERVER_BASE_URL + "/project",HttpMethod.POST, entity, String.class);
    }

    /*private JSONObject getCreateProjectJsonBody() throws JSONException {
        JSONObject requestObject=new JSONObject();

        JSONObject project = new JSONObject();
        project.put("title","test_projecttt");

        JSONObject attribute1 = new JSONObject();
        attribute1.put("refId","0753bd97-925c-4c08-816d-9cbefbf340a7");
        attribute1.put("value","1000");

        JSONObject attribute2 = new JSONObject();
        attribute2.put("refId","38a82921-10aa-4e33-b6c9-8c2c9d6757e5");
        attribute2.put("value","sample_value1");

        JSONObject attribute3 = new JSONObject();
        attribute3.put("refId","cd760223-1d95-45f0-92c1-2f3e61880819");
        attribute3.put("value","sample_value2");

        JSONArray attributes= new JSONArray();
        attributes.put(attribute1);
        attributes.put(attribute2);
        attributes.put(attribute3);

        requestObject.put("project",project);
        requestObject.put("attributes",attributes);

        return requestObject;

    }*/


}