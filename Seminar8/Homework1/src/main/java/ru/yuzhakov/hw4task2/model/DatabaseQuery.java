package ru.yuzhakov.hw4task2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "query")
@ConfigurationPropertiesScan
@Getter
@Setter
public class DatabaseQuery {
    private String selectAll;
    private String insert;
    private String delete;
    private String update;
    private String select;

}
