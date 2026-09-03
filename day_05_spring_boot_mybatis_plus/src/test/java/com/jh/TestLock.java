package com.jh;

import com.jh.entity.Bank;
import com.jh.mapper.BankMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestLock {
    @Resource
    private BankMapper mapper;

    @Test
    public void testUpdate() {
        Bank bank = mapper.selectById(1);
        bank.setMoney(bank.getMoney() + 500);
        mapper.updateById(bank);
    }
}
