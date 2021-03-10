package com.czz.controller;


import com.czz.entity.CommonResult;
import com.czz.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author EiletXie
 * @Since 2020/3/10 16:27
 */
@RestController

public class OrderZKController {

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;
/*
    @GetMapping(value = "/consumer/payment/get/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/get/id",String.class);
        return result;
    }*/

    @GetMapping("/consumer/payment/consul")
    public String payment() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);


    }
}
