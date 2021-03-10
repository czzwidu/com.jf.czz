package com.Controller;

import com.Srevice.hyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class paymentConteoller {

@Resource
    private hyService hyService;

@Value("${server.port}")
    private  String serverPort;

    @GetMapping("/payment/hyStrix/ok/{id}")
    public  String paymentInfo(@PathVariable("id") Integer id){
        String pament=hyService.paymentInfo(id);
        System.out.println(pament);
        return  pament;

    }
    @GetMapping("/payment/hyStrix/timeout/{id}")
    public  String paymentInfoTimeout(@PathVariable("id") Integer id){
        String pament=hyService.paymentInfoTimeOut(id);
         System.out.println(pament);
        return  pament;

    }

    @GetMapping("/payment/hyStrix/{id}")
    public  String paymentInfoT(@PathVariable("id") Integer id){
        String pament=hyService.paymentCircuitBreaker(id);
        System.out.println(pament);
        return  pament;

    }

}
