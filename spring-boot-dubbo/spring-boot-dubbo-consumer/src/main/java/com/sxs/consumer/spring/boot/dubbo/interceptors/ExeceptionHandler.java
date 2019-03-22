package com.sxs.consumer.spring.boot.dubbo.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: ExeceptionHandler
 * @Description: 异常处理拦截器
 * @Author: 尚先生
 * @CreateDate: 2019/3/21 21:57
 * @Version: 1.0
 */
@RestControllerAdvice(basePackages = "com.sxs.consumer.spring.boot.dubbo.controller")
public class ExeceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * controller层异常处理拦截实现
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(final Exception e) {
        logger.error("消费端执行异常，详细信息：[{}]", new Object[]{e});
        // TODO 此处可封装异常信息，异常码
        return new ResponseEntity<Object>("系统异常...", HttpStatus.OK);
    }
}
