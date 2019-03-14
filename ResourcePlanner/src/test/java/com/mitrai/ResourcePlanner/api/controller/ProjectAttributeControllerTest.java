package com.mitrai.ResourcePlanner.api.controller;


import com.mitrai.ResourcePlanner.api.dto.ProjectAttributeDTO;
import com.mitrai.ResourcePlanner.persistence.entity.DataType;
import org.junit.Test;

public class ProjectAttributeControllerTest extends ResourcePlannerServerBaseTestController{

    @Test
    public void testAddProjectAttribute(){
        ProjectAttributeDTO projectAttributeDTO=new ProjectAttributeDTO();
        projectAttributeDTO.setLabel("attribute_name_test1");
        projectAttributeDTO.setDataType(DataType.VARCHAR);
        projectAttributeDTO.setDefaultValue("default_value1");

    }

}