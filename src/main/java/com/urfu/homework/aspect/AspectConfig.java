package com.urfu.homework.aspect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {
    @Value("${api.max.requests}")
    private int maxRequests;

    public int getMaxRequests() {
        return maxRequests;
    }
}