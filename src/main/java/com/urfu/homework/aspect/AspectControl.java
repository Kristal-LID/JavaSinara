package com.urfu.homework.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AspectControl {

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Integer userId) {
        return new UserDTO(userId);
    }

}