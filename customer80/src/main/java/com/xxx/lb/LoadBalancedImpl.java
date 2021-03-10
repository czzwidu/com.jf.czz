package com.xxx.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBalancedImpl implements LoadBalanced {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    public final  int getAndIncrement(){

        int current;
        int next;
         //使用自选锁和cad 来获取当前下标
        do{
            current=this.atomicInteger.get();
            next=current>=2147483647?0:current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("***********newxt"+next);
        return  next;
    }







    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstance) {
        int index = getAndIncrement() % serviceInstance.size();

        return serviceInstance.get(index);
    }
}
