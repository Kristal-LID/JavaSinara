package com.urfu.homework;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class Hydrogen
        implements Engine{
    @PostConstruct
    public void init(){
        System.out.println("бин арбайтен");
    }

    @Override
    public void funktioniert() {
        System.out.println("Hydrogen arbeiten");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("bin уничтожен");
    }
}
