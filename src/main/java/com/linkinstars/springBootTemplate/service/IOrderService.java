package com.linkinstars.springBootTemplate.service;

/**
 * 测试批量插入
 * @author LinkinStar
 */
public interface IOrderService {

    /**
     * 使用for循环插入
     * @param orderAmount 插入条数
     */
    void forCycleInsert(int orderAmount);

    /**
     * 使用sql foreach插入
     * @param orderAmount 插入条数
     */
    void sqlCycleInsert(int orderAmount);

    /**
     * 使用批处理插入
     * @param orderAmount 插入条数
     */
    void batchInsert(int orderAmount);

    /**
     * 清空表数据
     */
    void deleteOrder();
}
