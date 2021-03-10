package com.xxx.controller;

import com.czz.entity.CommonResult;
import com.czz.entity.Payment;
import com.xxx.service.feignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
public class feignController {
    @Resource
    private feignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")    //哪个地址
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return paymentFeignService.getPaymentById(id);

    }
    @GetMapping(value ="/consumer/payment/layout/timeout")
    public String paymentFeignTimeout() {
        return   paymentFeignService.paymentFeignTimeout();

    }
}
