package com.yourpackage.controllers;

import com.develhope.Logging.services.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyService myService;

    @Value("${custom.env.var1}")
    private int var1;

    @Value("${custom.env.var2}")
    private int var2;

    @GetMapping("/")
    public String welcome() {
        logger.info("Welcome message requested");
        return "Welcome to my Spring Boot application!";
    }

    @GetMapping("/exp")
    public String calculatePower() {
        double result = myService.calculatePower();
        return "Power of " + var1 + " and " + var2 + " is: " + result;
    }

    @GetMapping("/get-errors")
    public void throwCustomError() {
        myService.throwCustomError();
    }
}
