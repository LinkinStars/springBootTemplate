package com.linkinstars.springBootTemplate.service.Impl;

import com.linkinstars.springBootTemplate.bean.UserEntity;
import com.linkinstars.springBootTemplate.dao.UserDao;
import com.linkinstars.springBootTemplate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        //测试抛出异常 throw new ServiceException();
        return userDao.listUser();
    }

    /**
     * 新增数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser() {
        userDao.addUser();
        //第二次添加会由于主键冲突抛出异常，测试回滚
        return userDao.addUser();
    }

}
