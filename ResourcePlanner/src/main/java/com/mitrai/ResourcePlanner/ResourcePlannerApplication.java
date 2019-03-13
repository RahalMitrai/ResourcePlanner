package com.mitrai.ResourcePlanner;

import java.util.HashMap;

import javax.sql.DataSource;

import com.mitrai.ResourcePlanner.config.UtillConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mitrai.ResourcePlanner.config.CustomRoutingDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} ,scanBasePackages = { "com.mitrai" })
@EnableAuthorizationServer
@Configuration
@Import({UtillConfiguration.class})
public class ResourcePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourcePlannerApplication.class, args);
		int i = 0;
		while (i < 10) {
			String password = "abcde";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}
	}

}
