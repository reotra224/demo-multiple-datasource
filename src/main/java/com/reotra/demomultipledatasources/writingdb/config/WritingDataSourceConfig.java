package com.reotra.demomultipledatasources.writingdb.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class WritingDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.write")
    public DataSourceProperties writingDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource writingDataSource() {
        return writingDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
