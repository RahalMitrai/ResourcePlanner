package com.mitrai.ResourcePlanner.api.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class ResourcePlannerServerBaseTestController {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Value("http://${server.host}:${server.port}${server.contextPath}")
    protected String RESOURCE_PLANNER_SERVER_BASE_URL;

    protected HttpHeaders httpHeaders = new HttpHeaders();

    @Before
    public void baseSetUp(){
        httpHeaders.add("tenantId", "tenantId1");
        httpHeaders.add("Content-Type", "application/json");
    }
}
