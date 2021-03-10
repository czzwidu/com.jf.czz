package com.xxx.controller;


import com.czz.entity.CommonResult;
import com.czz.entity.Payment;

import com.xxx.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;  //服务发现来暴露信息
     @Value("${server.port}")
    private  String servport;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,端口号: "+servport, result);
        } else {
            return new CommonResult(444, "插入数据库失败", result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功,端口号:  "+servport , payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询 ID: " + id, null);
        }
    }


    @GetMapping("/payment/discoveery")
    public Object discoveery(){
        //获取注册中心所有服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {

            System.out.println("service is +"+service);
        }
         // 获取暴露的服务名称下所有的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+" "+instance.getHost()+"/t"+instance.getInstanceId()+"/t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("payment/lb")
    public String getpaymentLB(){


        return  servport;
    }

    @GetMapping("/payment/layout/timeout")
    public String getpaymentLBtimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return  servport;
    }
}
