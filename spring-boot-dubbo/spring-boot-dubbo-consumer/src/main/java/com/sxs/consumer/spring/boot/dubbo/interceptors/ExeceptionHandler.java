package com.sxs.consumer.spring.boot.dubbo.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: ExeceptionHandler
 * @Description: 异常处理拦截器
 * @Author: 尚先生
 * @CreateDate: 2019/3/21 21:57
 * @Version: 1.0
 */
@RestControllerAdvice(basePackages = "com.sxs.consumer.spring.boot.dubbo.consumer")
public class ExeceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value = Exception.class)
    public String doHandlerException(Exception e){
        // TODO 自定义实现，异常处理拦截器
        logger.error("消费端执行异常，详细信息：[{}]", new Object[]{e});
        return "系统异常...";
    }
}
