package com.urfu.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HelicopterConstructor {
    Engine engine;

    @Autowired
    public HelicopterConstructor(Engine engine) {
        this.engine = engine;
    };

    public void execute() {
        engine.funktioniert();
    }
}
