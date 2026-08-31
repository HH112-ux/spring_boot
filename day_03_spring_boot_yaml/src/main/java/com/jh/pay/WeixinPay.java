package com.jh.pay;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")//如果你的开发环境是在prod，则使用微信进行支付
public class WeixinPay implements PayMent {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
