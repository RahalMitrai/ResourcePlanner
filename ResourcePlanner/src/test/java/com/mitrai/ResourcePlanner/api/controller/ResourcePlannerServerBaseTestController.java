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
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Before
    public void baseSetUp() throws JSONException {
        cleanData();
        insertValues();
        String accessToken=getAccessToken();
        httpHeaders.clear();
        if(httpHeaders.isEmpty()) {
            httpHeaders.add("tenantId", "tenantId1");
            httpHeaders.add("Authorization","Bearer "+accessToken);
        }

    }


    private String getAccessToken() throws JSONException {
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
        System.out.println(accessToken);
        return accessToken;
    }


    private void cleanData(){
        jdbcTemplate.execute("TRUNCATE TABLE oauth_client_details");
        jdbcTemplate.execute("TRUNCATE TABLE role_permission");
        jdbcTemplate.execute("TRUNCATE TABLE user_role");
        jdbcTemplate.execute("TRUNCATE TABLE user");
        jdbcTemplate.execute("TRUNCATE TABLE role");
        jdbcTemplate.execute("TRUNCATE TABLE permission");
    }


    private void insertValues(){

        jdbcTemplate.execute("INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES " +
                "('client_id',null,'$2a$10$tPG.GWYmJZuGu7VvJtZQqOEhQchI5j27Ej6AlfRvssFaBYqF9.pcO','trust,read,write','password,authorization_code,refresh_token,client_credentials,implicit',null,null,3600,18000,null,'1')");


        jdbcTemplate.execute("INSERT INTO user(id,ref_id,first_name,last_name,email,password) VALUES " +
                "(1,'dsdas1233-31232d-3213d-321312','dineth','chalitha','dineth@gmail.com','$2a$10$tPG.GWYmJZuGu7VvJtZQqOEhQchI5j27Ej6AlfRvssFaBYqF9.pcO')");

        jdbcTemplate.execute("INSERT INTO permission(id,name) VALUES (1,'createProjectAttribute')");

        jdbcTemplate.execute("INSERT INTO role(id,ref_id,name,description) VALUES (1,'dsda23-dsad2321-dasd2-223','testRole','testing purpose')");

        jdbcTemplate.execute("INSERT INTO role_permission(role_id,permission_id) VALUES(1,1)");

        jdbcTemplate.execute("INSERT INTO user_role(user_id,role_id) VALUES(1,1)");

    }
}
