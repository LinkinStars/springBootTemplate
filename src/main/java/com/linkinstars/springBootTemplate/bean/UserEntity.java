package com.linkinstars.springBootTemplate.bean;

/**
 * 实体类（POJO）
 * @author LinkinStar
 */
public class UserEntity {

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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", val='" + val + '\'' +
                '}';
    }
}
