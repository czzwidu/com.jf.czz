package com.xxx.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalanced {
 //收集活着的机器总数
ServiceInstance instance(List<ServiceInstance> serviceInstance);



}
