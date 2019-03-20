package com.sxs.consumer.spring.boot.dubbo.controller;

import com.sxs.consumer.spring.boot.dubbo.consumer.ServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloWorldController
 * @Description: 前端 Controller
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 23:17
 * @Version: 1.0
 */
@RestController
public class HelloWorldController {

    @Autowired
    private ServiceConsumer serviceConsumer;

    @GetMapping("/hello")
    public String hello(){
        String res = serviceConsumer.doSayHello("尚先生");
        System.err.println("rpc调用返回结果： " +res);
        return res;
    }
}
