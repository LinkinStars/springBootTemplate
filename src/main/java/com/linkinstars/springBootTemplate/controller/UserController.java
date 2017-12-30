package com.linkinstars.springBootTemplate.controller;

import com.linkinstars.springBootTemplate.bean.UserEntity;
import com.linkinstars.springBootTemplate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 控制层
 * Created by LinkinStar
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/test")
    public String test(HttpServletRequest request){
        List<UserEntity> userList = userService.listUser();
        for (UserEntity user : userList) {
            System.out.print("id : " + user.getId() + "  ");
            System.out.println("val : " +user.getVal());
        }
        request.setAttribute("userList", userList);
        return "index";
    }
}
