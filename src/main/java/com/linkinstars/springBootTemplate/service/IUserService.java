package com.linkinstars.springBootTemplate.service;

import com.linkinstars.springBootTemplate.bean.UserEntity;

import java.util.List;

/**
 * 服务层接口
 * Created by LinkinStar
 */
public interface IUserService {

    /**
     * 查询
     */
    List<UserEntity> listUser();

}
