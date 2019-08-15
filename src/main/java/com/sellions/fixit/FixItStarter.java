package com.sellions.fixit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sellions.fixit"})
public class FixItStarter {

    public static void main(String[] args) {
        SpringApplication.run(FixItStarter.class, args);
    }
}
