package com.czz.service;

import org.springframework.stereotype.Component;

/**
 * 用于集中降级 降低代码耦合行
 */
@Component
public class fackService implements  orderService{


    @Override
    public String paymentInfo(Integer id) {
        return "挂机了";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "呜呜呜呜呜";
    }
}
