package com.linkinstars.springBootTemplate.service.Impl;

import com.linkinstars.springBootTemplate.bean.OrderTestDO;
import com.linkinstars.springBootTemplate.dao.OrderDao;
import com.linkinstars.springBootTemplate.service.IOrderService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试批量插入
 * @author LinkinStar
 */
@Service
public class OrderServiceImpl implements IOrderService {
    
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    
    /**
     * 使用for循环插入
     * @param orderAmount 插入条数
     */
    @Override
    public void forCycleInsert(int orderAmount) {
        OrderTestDO orderTestDO = buildOrder();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < orderAmount; i++) {
            orderDao.insertOrder(orderTestDO);
        }
        System.out.println("总共执行时间：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 使用sql foreach插入
     * @param orderAmount 插入条数
     */
    @Override
    public void sqlCycleInsert(int orderAmount) {
        OrderTestDO orderTestDO = buildOrder();

        List<OrderTestDO> orderTestDOList = new ArrayList<>();
        for (int i = 0; i < orderAmount; i++) {
            orderTestDOList.add(orderTestDO);
        }

        long startTime = System.currentTimeMillis();
        orderDao.insertManyOrders(orderTestDOList);
        System.out.println("总共执行时间：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 使用批处理插入
     * @param orderAmount 插入条数
     */
    @Override
    public void batchInsert(int orderAmount) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        OrderDao orderDao = session.getMapper(OrderDao.class);
        OrderTestDO orderTestDO = buildOrder();

        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < orderAmount; i++) {
            orderDao.insertOrder(orderTestDO);
            //每1000条提交一次防止内存溢出
            if(i%1000 == 999){
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        
        System.out.println("总共执行时间：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 清空表数据
     */
    @Override
    public void deleteOrder() {
        orderDao.deleteOrder();
    }

    private static OrderTestDO buildOrder(){
        OrderTestDO orderTestDO = new OrderTestDO();
        orderTestDO.setOrderId("订单号码");
        orderTestDO.setOrderName("订单名称");
        orderTestDO.setOrderStatus(1);
        orderTestDO.setOrderContent("订单内容订单内容订单内容订单内容订单内容订单内容订单内容订单内容订单内容订单内容订单内容");
        orderTestDO.setAddTime(new Timestamp(System.currentTimeMillis()));
        return  orderTestDO;
    }
}
