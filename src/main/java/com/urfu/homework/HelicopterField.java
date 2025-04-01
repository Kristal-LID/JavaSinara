package com.urfu.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelicopterField {

    @Autowired
    private Engine engine;

    public void execute() {
        engine.funktioniert();
    }

}
