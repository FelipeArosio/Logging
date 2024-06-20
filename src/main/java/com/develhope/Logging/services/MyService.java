package com.develhope.Logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    @Value("${custom.env.var1}")
    private int var1;

    @Value("${custom.env.var2}")
    private int var2;

    public double calculatePower() {
        logger.debug("Calculating power of {} and {}", var1, var2);
        double result = Math.pow(var1, var2);
        logger.debug("Calculation finished");
        return result;
    }

    public void throwCustomError() {
        logger.error("Custom error occurred");
        throw new CustomErrorException("This is a custom error");
    }

    // Custom exception class
    public static class CustomErrorException extends RuntimeException {
        public CustomErrorException(String message) {
            super(message);
        }
    }
}

