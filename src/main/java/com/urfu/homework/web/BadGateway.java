package com.urfu.homework.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_GATEWAY, reason="create error")
public class BadGateway extends RuntimeException {
    public BadGateway(String message) {
        super(message);
    }
}