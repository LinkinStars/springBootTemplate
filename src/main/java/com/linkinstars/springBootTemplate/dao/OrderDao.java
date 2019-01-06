package com.linkinstars.springBootTemplate.dao;

import com.linkinstars.springBootTemplate.bean.OrderTestDO;

import java.util.List;

/**
 * 测试批量插入
 * @author LinkinStar
 */
public interface OrderDao {

    /**
     * 插入单条记录
     * @param orderTestDO
     */
    void insertOrder(OrderTestDO orderTestDO);

    /**
     * 插入多条记录
     * @param orderTestDOList
     */
    void insertManyOrders(List<OrderTestDO> orderTestDOList);

    /**
     * 删除表中所有记录 
     */
    void deleteOrder();
}
