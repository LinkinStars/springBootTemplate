package com.linkinstars.springBootTemplate.service;

import com.linkinstars.springBootTemplate.bean.UserEntity;

import java.util.List;

/**
 * 服务层接口
 * @author LinkinStar
 */
public interface IUserService {

    /**
     * 查询用户列表
     * @return 用户列表
     */
    List<UserEntity> listUser();

}
