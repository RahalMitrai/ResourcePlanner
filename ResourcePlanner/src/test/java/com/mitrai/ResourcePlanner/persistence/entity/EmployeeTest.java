package com.mitrai.ResourcePlanner.persistence.entity;

import com.mitrai.ResourcePlanner.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void createEmployee(){
        Employee employee=new Employee();
        employee.setTitle("Gayan");
        employeeService.save(employee);
    }

}