package com.linkinstars.springBootTemplate.service.Impl;

import com.linkinstars.springBootTemplate.bean.UserVO;
import com.linkinstars.springBootTemplate.service.IUserCacheService;
import com.linkinstars.springBootTemplate.util.CacheUserDb;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息缓存服务
 * @author LinkinStar
 */
@Service
@CacheConfig(cacheNames="user")
public class UserCacheServiceImpl implements IUserCacheService {
    
    /**
     * 查询缓存用户数据
     * 第一次查询并在控制台输出信息
     * 之后都从缓存中取
     */
    @Override
    @Cacheable(key = "'list'")
    public List<UserVO> listUser() {
        System.out.println("调用了方法，没有从redis取");
        //模拟数据库查询
        return CacheUserDb.userVOList;
    }

    /**
     * 添加一个缓存用户
     * 并且操作缓存
     */
    @Override
    @CachePut(key = "'list'")
    public List<UserVO> addUser() {
        //模拟数据库添加
        int id = CacheUserDb.userVOList.size() + 1;
        CacheUserDb.userVOList.add(new UserVO(id, "val - " + id));
        return CacheUserDb.userVOList;
    }

    /**
     * 删除一个缓存用户
     * 并不操作缓存
     */
    @Override
    public boolean deleteUser() {
        //模拟数据库删除
        CacheUserDb.userVOList.remove(0);
        return true;
    }
}
