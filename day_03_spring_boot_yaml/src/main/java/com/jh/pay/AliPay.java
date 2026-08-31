package com.jh.pay;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")//如果你的开发环境是在dev，则使用支付宝进行支付
public class AliPay implements PayMent {
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
