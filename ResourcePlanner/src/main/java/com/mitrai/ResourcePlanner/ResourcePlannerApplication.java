package com.mitrai.ResourcePlanner;

import com.mitrai.ResourcePlanner.config.DBConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} ,scanBasePackages = { "com.mitrai" })
@Import({DBConfiguration.class})
public class ResourcePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourcePlannerApplication.class, args);
		/*int i = 0;
		while (i < 10) {
			String password = "abcde";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}*/
	}

}
