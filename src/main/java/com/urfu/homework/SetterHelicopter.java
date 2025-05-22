package com.urfu.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterHelicopter {
    Engine engine;

    @Autowired
    public void setHelicopter(Engine engine) {
        this.engine = engine;
    }

    public void execute() {
        engine.funktioniert();
    }
}
