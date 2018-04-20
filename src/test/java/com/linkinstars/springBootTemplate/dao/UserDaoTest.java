package com.linkinstars.springBootTemplate.dao;

import com.linkinstars.springBootTemplate.bean.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author LinkinStar
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void listUser() {
        List<UserEntity> list = userDao.listUser();
        Assert.assertNotNull(list);
    }
}