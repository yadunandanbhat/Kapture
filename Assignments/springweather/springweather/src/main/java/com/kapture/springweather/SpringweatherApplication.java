package com.kapture.springweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringweatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringweatherApplication.class, args);
    }

}
