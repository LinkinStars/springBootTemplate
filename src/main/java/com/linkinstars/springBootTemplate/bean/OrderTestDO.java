package com.linkinstars.springBootTemplate.bean;

import java.sql.Timestamp;

/**
 * 测试订单表
 * @author LinkinStar
 */
public class OrderTestDO {

	private int id;  //id
	private String orderId;  //订单号
	private String orderName;  //订单名称
	private int orderStatus;  //订单状态
	private String orderContent;  //订单说明
	private Timestamp addTime;  //订单时间

    /**
     * id
     */
	public int getId() {
        return id;
	}

    /**
     * id
     */
	public void setId(int id) {
        this.id = id;
	}

    /**
     * 订单号
     */
	public String getOrderId() {
        return orderId;
	}

    /**
     * 订单号
     */
	public void setOrderId(String orderId) {
        this.orderId = orderId;
	}

    /**
     * 订单名称
     */
	public String getOrderName() {
        return orderName;
	}

    /**
     * 订单名称
     */
	public void setOrderName(String orderName) {
        this.orderName = orderName;
	}

    /**
     * 订单状态
     */
	public int getOrderStatus() {
        return orderStatus;
	}

    /**
     * 订单状态
     */
	public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
	}

    /**
     * 订单说明
     */
	public String getOrderContent() {
        return orderContent;
	}

    /**
     * 订单说明
     */
	public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
	}

    /**
     * 订单时间
     */
	public Timestamp getAddTime() {
        return addTime;
	}

    /**
     * 订单时间
     */
	public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
	}

}