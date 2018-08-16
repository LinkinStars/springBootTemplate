package com.linkinstars.springBootTemplate.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 * @author LinkinStar
 */
public class LogUtil {

    /**
     * 将信息打印到自定义日志（my_info.log）中
     * @param message 需要被打印的信息
     */
    public static void printLog(String message){
        Logger logger = LoggerFactory.getLogger("my_info");
        logger.info(message);
    }

    /**
     * 将信息打印到自定义日志（system_error.log）中
     * @param e 异常信息
     */
    public static void printLog(Exception e, Class<?> clazz){
        Logger logger = LoggerFactory.getLogger(clazz);

        StringBuffer logOut = new StringBuffer();
        logOut.append("\n");
        logOut.append(e.toString());
        logOut.append("\n");

        StackTraceElement[] errorList = e.getStackTrace();
        for (StackTraceElement stackTraceElement : errorList) {
            logOut.append(stackTraceElement.toString());
            logOut.append("\n");
        }

        logOut.append("\n");

        logger.error(logOut.toString());
    }

}
