package com.linkinstars.springBootTemplate.service.Impl;

import com.linkinstars.springBootTemplate.bean.UserEntity;
import com.linkinstars.springBootTemplate.dao.UserDao;
import com.linkinstars.springBootTemplate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务层
 * @author LinkinStar
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    /**
     * 查询
     */
    @Override
    public List<UserEntity> listUser() {
        return userDao.listUser();
    }

}
