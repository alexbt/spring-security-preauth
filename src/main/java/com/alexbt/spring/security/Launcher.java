package com.alexbt.spring.security;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Launcher {

    public static void main(String[] args) {
        new SpringApplicationBuilder() //
                .sources(Launcher.class)//
                .run(args);
    }
}
