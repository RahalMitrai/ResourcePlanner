package com.mitrai.ResourcePlanner.api.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)

public class ProjectControllerTest {

    private static final String NEW_PROJECT = "/";



    @Test
    public void addProject() throws Exception {
        JSONObject requestObject=getCreateProjectJsonBody();
        System.out.println(requestObject.toString());

        RequestBuilder requestBuilderCompleteReq =
                MockMvcRequestBuilders.post(NEW_PROJECT).contentType(MediaType.APPLICATION_JSON)
                        .content(requestObject.toString());

    }

    private JSONObject getCreateProjectJsonBody() throws JSONException {
        JSONObject requestObject=new JSONObject();

        JSONObject project = new JSONObject();
        project.put("title","test_project");

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

    }


}