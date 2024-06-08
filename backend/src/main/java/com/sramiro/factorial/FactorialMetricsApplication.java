package com.sramiro.factorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sramiro.factorial")
public class FactorialMetricsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactorialMetricsApplication.class, args);
    }

}
