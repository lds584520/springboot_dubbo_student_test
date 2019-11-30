package com.qf.web_managers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
public class WebManagersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebManagersApplication.class, args);
    }

}
