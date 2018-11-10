package com.linkinstars.springBootTemplate.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkinstars.springBootTemplate.bean.UserEntity;
import com.linkinstars.springBootTemplate.service.IUserService;
import com.linkinstars.springBootTemplate.util.FileHandleUtil;
import com.linkinstars.springBootTemplate.util.RedisUtil;
import com.linkinstars.springBootTemplate.validator.NotNullStringValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 控制层
 * @author LinkinStar
 */
@Controller
public class UserController {

    /** 用户服务 **/
    @Autowired
    private IUserService userService;

    /** 用户服务 **/
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public String test(HttpServletRequest request, @RequestParam(required = false) Integer pageNum){
        //测试校验字符串参数
        String checkedString = "";
        Result validatorResult = FluentValidator.checkAll()
                .on(checkedString, new NotNullStringValidator("测试姓名"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        if (!validatorResult.isSuccess()) {
            System.out.println(validatorResult.getErrors());
        }

        //分页参数校验
        int pageSize = 3;
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }

        //进行分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> userList = userService.listUser();
        PageInfo pageInfo = new PageInfo(userList);

        //设置返回参数
        request.setAttribute("userList", userList);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("pageSum", pageInfo.getPages());

        //测试session存放redis
        HttpSession session = request.getSession();
        System.out.println("session数据：" + session.getAttribute("xxx"));
        session.setAttribute("xxx","123");
        System.out.println("session数据：" + session.getAttribute("xxx"));


        //测试redis
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setVal("xxx");

        redisUtil.set("xxx", user);
        Object object = redisUtil.get("xxx");
        UserEntity userTemp = (UserEntity) object;

        System.out.println("redis数据获取为: " + userTemp);
        redisUtil.delete("xxx");
        System.out.println("redis删除数据之后获取为: " + redisUtil.get("xxx"));


        //测试事务回滚
        //userService.addUser();

        return "index";
    }

    /**
     * 测试返回json
     */
    @RequestMapping("/test/get")
    @ResponseBody
    public String get() throws Exception{
        JSONObject data = new JSONObject();
        data.put("id",1);
        data.put("name", "名称");
        data.put("val", "测试");
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",1);
        jsonObject.put("message","请求成功");
        jsonObject.put("data", data);
        return jsonObject.toString();
    }

    /**
     * 测试文件上传
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        String fileURL = FileHandleUtil.upload(file.getInputStream(), "image/", file.getOriginalFilename());
        return "文件存放路径为: " + fileURL;
    }
}
