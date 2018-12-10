package com.linkinstars.springBootTemplate.controller;

import com.linkinstars.springBootTemplate.service.IUserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LinkinStar
 */
@RestController
@RequestMapping("/cache/user")
public class UserCacheController {
    
    @Autowired
    private IUserCacheService userCacheService;
    
    @RequestMapping("list")
    public String listUser() {
        return userCacheService.listUser().toString();
    }
    
    @RequestMapping("add")
    public String addUser() {
        return String.valueOf(userCacheService.addUser());
    }

    @RequestMapping("delete")
    public String deleteUser() {
        return String.valueOf(userCacheService.deleteUser());
    }
}
