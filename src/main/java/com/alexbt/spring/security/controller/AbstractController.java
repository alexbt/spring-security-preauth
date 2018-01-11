package com.alexbt.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

public abstract class AbstractController {
    public static final String ROLE_USER = "USER";

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String securedForyAdmin() {
        return "ok";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String securedForUser() {
        return "ok";
    }

    @GetMapping("/any")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String securedForAny() {
        return "ok";
    }

    @GetMapping("/all")
    @PreAuthorize("permitAll()")
    public String securedForAll() {
        return "ok";
    }

    @GetMapping("/principal")
    @PreAuthorize("permitAll()")
    public String getPrincipal(Principal principal) {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        return "principal: " + principal.getName()
                + "\n" + token.getPrincipal()
                + "\n" + token.getAuthorities()
                + "\n" + token.getCredentials()
                + "\n" + token.getPrincipal();
    }

    @GetMapping("/dynamic")
    @PreAuthorize("#role == 'USER'")
    public String securedForDynamic(@RequestParam("role") String role) {
        return "ok";
    }

    @GetMapping("/dynamic2")
    @PreAuthorize("#role == T(com.alexbt.spring.security.controller.AbstractController).ROLE_USER")
    public String securedForDynamicStatic(@RequestParam("role") String role) {
        return "ok";
    }
}
