package com.example.SpringCloudClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloud")
@RefreshScope
public class HomeController {

    @Value("${app.name}")
    String appName;

    @GetMapping("/home")
    public String home(){
        return "Welcome to Spring Cloud Client! " + appName;
    }
}
