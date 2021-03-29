package com.github.action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActionApplication.class, args);
    }

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @Value("${logging-module-version}")
    private String version;

    @GetMapping("/")
    public String version() {
        return String.format("Project Version : %s", version);
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "healthy";
    }


}
