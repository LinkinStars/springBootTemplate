package com.linkinstars.springBootTemplate.aop;

import com.linkinstars.springBootTemplate.util.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * aop拦截controller
 * @author LinkinStar
 */
@Component
@Aspect
public class DemoAop {

    @Pointcut("execution(* com.linkinstars.springBootTemplate.controller.*.*(..))")
    private void logPointcut(){}

    @Before("logPointcut()")
    public void before(JoinPoint joinPoint){
        LogUtil.printLog("AOP的before方法执行");
    }
}
