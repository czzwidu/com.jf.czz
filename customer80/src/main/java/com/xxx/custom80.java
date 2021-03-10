package com.xxx;


import com.aaa.myRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = myRule.class)
public class custom80 {

    public static void main(String[] args) {
        SpringApplication.run(custom80.class,args);
    }
}
