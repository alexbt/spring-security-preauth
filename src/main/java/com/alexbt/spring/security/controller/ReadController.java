package com.alexbt.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/read")
public class ReadController extends AbstractController {

    @GetMapping
    @PreAuthorize("hasAuthority('READ_RIGHT')")
    public String getPrincipal(Principal principal) {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        return "principal: " + principal.getName()
                + "\n" + token.getPrincipal()
                + "\n" + token.getAuthorities()
                + "\n" + token.getCredentials()
                + "\n" + token.getPrincipal();
    }
}
