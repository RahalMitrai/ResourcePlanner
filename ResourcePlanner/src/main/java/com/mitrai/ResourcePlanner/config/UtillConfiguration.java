package com.mitrai.ResourcePlanner.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class UtillConfiguration {

    @Value("${database1.datasource.url}")
    private String db1Url;

    @Value("${database1.datasource.username}")
    private String db1Username;

    @Value("${database1.datasource.password}")
    private String db1Password;

    @Value("${database.datasource.driver}")
    private String dbdriver;

    @Value("${database2.datasource.url}")
    private String db2Url;

    @Value("${database2.datasource.username}")
    private String db2Username;

    @Value("${database2.datasource.password}")
    private String db2Password;



    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DataSource dataSource() {
        CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbdriver);
        dataSource.setUrl(db1Url);
        dataSource.setUsername(db1Username);
        dataSource.setPassword(db1Password);

        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName(dbdriver);
        dataSource1.setUrl(db2Url);
        dataSource1.setUsername(db2Username);
        dataSource1.setPassword(db2Password);
        HashMap<Object, Object> hashMap = new HashMap();

        hashMap.put("tenantId1", dataSource);
        hashMap.put("tenantId2", dataSource1);

        customDataSource.setTargetDataSources(hashMap);
        return customDataSource;
    }
}
