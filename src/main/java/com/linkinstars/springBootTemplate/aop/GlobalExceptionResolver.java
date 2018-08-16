package com.linkinstars.springBootTemplate.aop;

import com.linkinstars.springBootTemplate.exception.ServiceException;
import com.linkinstars.springBootTemplate.util.LogUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理
 * @author LinkinStar
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(value = ServiceException.class)
    public @ResponseBody String serviceCommonExceptionHandler(ServiceException e) {
        //对捕获的异常进行处理并打印日志等，之后返回json数据，方式与Controller相同
        return "{'code':-1}";
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(Exception exception) {
        //当然也可以直接返回ModelAndView等类型，然后跳转相应的错误页面，这都根据实际的需要进行使用
        LogUtil.printLog(exception, Exception.class);
        LogUtil.printLog("出现异常");
        return null;
    }
}
