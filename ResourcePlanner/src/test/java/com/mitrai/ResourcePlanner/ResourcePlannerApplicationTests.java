package com.mitrai.ResourcePlanner;

import com.mitrai.ResourcePlanner.api.controller.ProjectAttributeControllerTest;
import com.mitrai.ResourcePlanner.api.controller.ProjectControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		ProjectControllerTest.class,
		ProjectAttributeControllerTest.class
})

public class ResourcePlannerApplicationTests {


}

