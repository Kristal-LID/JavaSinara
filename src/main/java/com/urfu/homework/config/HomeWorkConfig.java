package com.urfu.homework.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@Data
@ConfigurationProperties(prefix = "homeworkconfig")
public class HomeWorkConfig {
    private String title;
    private List<String> words;
    private Integer num;
}
