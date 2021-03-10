package com.czz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class dashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(dashboard9001.class, args);
    }
}
