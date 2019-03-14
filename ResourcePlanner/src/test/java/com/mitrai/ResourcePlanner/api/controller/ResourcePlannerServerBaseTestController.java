package com.mitrai.ResourcePlanner.api.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class ResourcePlannerServerBaseTestController {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Value("http://${server.host}:${server.port}${server.servlet.context-path}")
    protected String RESOURCE_PLANNER_SERVER_BASE_URL;

    protected static final String OAUTH_TOKEN_URL = "/oauth/token";


    protected HttpHeaders httpHeaders = new HttpHeaders();


    @Before
    public void baseSetUp() throws JSONException {
        String accessToken=getAccessToken();
        httpHeaders.clear();
        if(httpHeaders.isEmpty()) {
            httpHeaders.add("tenantId", "tenantId1");
            httpHeaders.add("Authorization","Bearer "+accessToken);
        }

    }


    public String getAccessToken() throws JSONException {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.setBasicAuth("client_id","abcde");
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("username","dineth@gmail.com");
        map.add("password","abcde");
        map.add("grant_type","password");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, httpHeaders);
        ResponseEntity<String> response = testRestTemplate.postForEntity(  OAUTH_TOKEN_URL, request , String.class );
        JSONObject jsonObj = new JSONObject(response.getBody());
        String accessToken =  jsonObj.getString("access_token");
        return accessToken;
    }
}
