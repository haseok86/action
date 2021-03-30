package com.github.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class ActionApplication {

    @Autowired
    ApplicationContext applicationContext;

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

    @GetMapping("/marimox")
    public String marimox() {
        return "marimox";
    }

    @GetMapping("/profile")
    public String profile() {
        final Environment environment = applicationContext.getEnvironment();
        return Arrays.toString(environment.getActiveProfiles());
    }


}
