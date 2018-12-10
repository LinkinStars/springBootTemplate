package com.linkinstars.springBootTemplate.bean;

import java.io.Serializable;

/**
 * 用户数据
 * @author LinkinStar
 */
public class UserVO implements Serializable {

    private static final long serialVersionUID = 3732941597434585757L;
    
    private int id;
    private String val;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public UserVO(int id, String val) {
        this.id = id;
        this.val = val;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", val='" + val + '\'' +
                '}';
    }
}
