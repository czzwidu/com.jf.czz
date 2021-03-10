package com.czz.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = fackService.class)  //指定调用哪个微服务
public interface orderService {

    @GetMapping("/payment/hyStrix/ok/{id}")
    public  String paymentInfo(@PathVariable("id") Integer id);

    @GetMapping("/payment/hyStrix/timeout/{id}")
    public  String paymentInfoTimeout(@PathVariable("id") Integer id);
}
