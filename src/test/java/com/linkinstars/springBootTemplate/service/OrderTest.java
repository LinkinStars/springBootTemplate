package com.linkinstars.springBootTemplate.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 批量新增测试
 * @author LinkinStar
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    private static final int ORDER_AMOUNT = 100;
    
    @Autowired
    private IOrderService orderService;
    
    @Test
    public void forCycleInsert() {
        orderService.deleteOrder();
        orderService.forCycleInsert(ORDER_AMOUNT);
    }

    @Test
    public void sqlCycleInsert() {
        orderService.deleteOrder();
        orderService.sqlCycleInsert(ORDER_AMOUNT);
    }

    @Test
    public void batchInsert() {
        orderService.deleteOrder();
        orderService.batchInsert(ORDER_AMOUNT);
    }

    @Test
    public void all() {
        orderService.deleteOrder();
        
        orderService.forCycleInsert(ORDER_AMOUNT);
        orderService.sqlCycleInsert(ORDER_AMOUNT);
        orderService.batchInsert(ORDER_AMOUNT);
        System.out.println("");
        orderService.forCycleInsert(ORDER_AMOUNT);
        orderService.sqlCycleInsert(ORDER_AMOUNT);
        orderService.batchInsert(ORDER_AMOUNT);
    }

    @Test
    public void deleteOrder() {
        orderService.deleteOrder();
    }
}