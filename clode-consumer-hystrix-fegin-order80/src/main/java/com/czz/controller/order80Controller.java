package com.czz.controller;


import com.czz.service.orderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //全局指定的服务降级兜底方法  默认使用该方法  自己指定则使用自己的
public class order80Controller {
    @Resource
    private orderService orderService;

    @GetMapping("/comsumer/payment/hyStrix/ok/{id}")
    public  String paymentInfo(@PathVariable("id") Integer id){
       return orderService.paymentInfo(id);


    }

    @GetMapping("/comsumer/payment/hyStrix/timeout/{id}")
 /*   @HystrixCommand(fallbackMethod = "paymentInfoTimeOut_handle",commandProperties = {

            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")

    })*/
  /*  @HystrixCommand*/
    public  String paymentInfoTimeout(@PathVariable("id") Integer id){
        return orderService.paymentInfoTimeout(id);
    }

    public  String paymentInfoTimeOut_handle(@PathVariable("id") Integer id){
        return "我是消费者，你们这速度太慢了 ";
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }
}
