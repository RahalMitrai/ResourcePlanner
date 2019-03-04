package com.mitrai.ResourcePlanner;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mitrai.ResourcePlanner.config.CustomRoutingDataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} ,scanBasePackages = { "com.mitrai" })
public class ResourcePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourcePlannerApplication.class, args);
	}

}
