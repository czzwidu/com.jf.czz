package com.xxx.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
            //开启详细日志
        return  Logger.Level.FULL;
    }



}
