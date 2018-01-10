package com.linkinstars.springBootTemplate.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkinstars.springBootTemplate.bean.UserEntity;
import com.linkinstars.springBootTemplate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String test(HttpServletRequest request, @RequestParam(required = false) Integer pageNum){
        int pageSize = 3;
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> userList = userService.listUser();
        PageInfo pageInfo = new PageInfo(userList);
        request.setAttribute("userList", userList);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("pageSum", pageInfo.getPages());
        return "index";
    }
}
