package com.czz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Custom180 {

    public static void main(String[] args) {
        SpringApplication.run(Custom180.class,args);
    }
}
