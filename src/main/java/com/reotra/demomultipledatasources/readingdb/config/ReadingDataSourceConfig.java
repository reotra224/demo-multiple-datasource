package com.reotra.demomultipledatasources.readingdb.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ReadingDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.read")
    public DataSourceProperties readingDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource readingDataSource() {
        return readingDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
