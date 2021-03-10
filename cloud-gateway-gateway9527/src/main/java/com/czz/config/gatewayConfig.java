package com.czz.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class gatewayConfig {
    @Bean
    public RouteLocator gataw(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator path_route = routes.route("path_route", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();


        return  path_route;
    }
}
