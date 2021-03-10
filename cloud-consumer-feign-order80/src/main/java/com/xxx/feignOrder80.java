package com.xxx;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //开启Feign
public class feignOrder80{
  public static void main(String[] args) {
    SpringApplication.run(feignOrder80.class,args);
  }


}
