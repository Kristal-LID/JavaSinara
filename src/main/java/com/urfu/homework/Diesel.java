package com.urfu.homework;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class Diesel
implements Engine{


    @PostConstruct
    public void init(){
        System.out.println("бин арбайтен");
    }

    @Override
    public void funktioniert() {
        System.out.println("Diesel arbeiten");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("bin уничтожен");
    }
}

