package com.shoestore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoeStoreApplication {
    private static final Logger LOGGER = LogManager.getLogger(ShoeStoreApplication.class);

    public static void main(String[] args) {
        LOGGER.info("About to launch...");
        SpringApplication.run(ShoeStoreApplication.class, args);
    }
}
