package com.urfu.homework.springsecurity;


import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiController {

    @GetMapping("/public/api")
    public String publicApi() {
        return "This is public API - доступ разрешен для всех";
    }

    @GetMapping("/admin/api")
    @RolesAllowed("ADMIN")
    public UserInfo adminApi(@AuthenticationPrincipal UserDetails userDetails) {
        return getUserInfo(userDetails);
    }

    @GetMapping("/support/api")
    @RolesAllowed("SUPPORT")
    public UserInfo supportApi(@AuthenticationPrincipal UserDetails userDetails) {
        return getUserInfo(userDetails);
    }

    private UserInfo getUserInfo(UserDetails userDetails) {
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new UserInfo(userDetails.getUsername(), roles);
    }
}
