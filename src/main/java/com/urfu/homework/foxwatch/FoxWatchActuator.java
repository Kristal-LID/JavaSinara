package com.urfu.homework.foxwatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Endpoint(id = "foxwatch")
public class FoxWatchActuator {
    private static final Logger logger = LoggerFactory.getLogger(FoxWatchActuator.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ReadOperation
    public String getFoxWatchStatus() {
        String status = "FoxWatch Status: ACTIVE | Last checked: " +
                formatter.format(LocalDateTime.now());
        logger.info(status);
        return status;
    }
}
