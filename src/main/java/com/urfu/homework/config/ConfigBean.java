package com.urfu.homework.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class ConfigBean {
    @Bean
    @Profile("test")
    public String TestConfigBean() {
        log.info("TestBean создан успешно");
        return "TestBean";
    }

    @Bean
    @ConditionalOnExpression("#{'${homeworkconfig.env-var}' != 'default'}")
    public String notDefaultBean() {
        log.info("создан NotDefaultBean");
        return "создан NotDefaultBean";
    }

    @Bean
    @ConditionalOnBean(name = "testBean")
    public String existTestBean() {
        log.info("создан AnotherOneTestBean");
        return "создан AnotherOneTestBean";
    }
}

