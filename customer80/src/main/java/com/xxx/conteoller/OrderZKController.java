package com.xxx.conteoller;


import com.czz.entity.CommonResult;
import com.czz.entity.Payment;
import com.xxx.lb.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author EiletXie
 * @Since 2020/3/10 16:27
 */
@RestController

public class OrderZKController {

    private static  final String INVOKE_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private LoadBalanced loadBalanced;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
/*
    @GetMapping(value = "/consumer/payment/get/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/get/id",String.class);
        return result;
    }*/
@GetMapping("consumer/payment/create")
   public CommonResult<Payment> creat(Payment payment){

       return restTemplate.postForObject(INVOKE_URL+"/payment/create",payment,CommonResult.class);
   }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return restTemplate.getForObject(INVOKE_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("consumer/payment/lb")
    public String getpaymentLB(){

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null || instances.size()<=0){
            return  null;
        }
        ServiceInstance instance = loadBalanced.instance(instances);
        URI uri = instance.getUri();


        return  restTemplate.getForObject(uri+"/payment/lb",String.class);
    }


}
