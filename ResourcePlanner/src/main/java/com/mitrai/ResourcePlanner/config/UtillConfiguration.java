package com.mitrai.ResourcePlanner.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class UtillConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DataSource dataSource() {
        CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rp_db1");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/rp_db2");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root");
        HashMap<Object, Object> hashMap = new HashMap();

        hashMap.put("tenantId1", dataSource);
        hashMap.put("tenantId2", dataSource1);

        customDataSource.setTargetDataSources(hashMap);
        return customDataSource;
    }
}
