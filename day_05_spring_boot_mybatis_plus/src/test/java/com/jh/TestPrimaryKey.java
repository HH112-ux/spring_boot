package com.jh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jh.entity.Goods;
import com.jh.enums.StatusEnum;
import com.jh.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestPrimaryKey {
    @Resource
    private GoodsMapper mapper;

    @Test
    public void save() {
        Goods goods = new Goods();
        goods.setName("商品3");
        mapper.insert(goods);
    }

    @Test
    public void update() {
        Goods goods = new Goods();
        goods.setId(12);
        goods.setName("商品4");
        mapper.updateById(goods);
    }

    @Test
    public void testEnum() {
        Goods goods = new Goods();
        goods.setName("商品6");
        goods.setStatus(StatusEnum.OUT);
        mapper.insert(goods);
    }

    @Test
    public void selectEnum() {
        List<Goods> goods = mapper.selectList(null);
        goods.forEach(System.out::println);
    }

    @Test
    public void selectEnumCondition() {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("status", StatusEnum.IN);
        List<Goods> goods = mapper.selectList(wrapper);
        goods.forEach(System.out::println);
    }
}
