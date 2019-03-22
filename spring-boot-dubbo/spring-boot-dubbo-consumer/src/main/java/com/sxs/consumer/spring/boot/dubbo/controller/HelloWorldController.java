package com.sxs.consumer.spring.boot.dubbo.controller;

import com.sxs.consumer.spring.boot.dubbo.consumer.ServiceConsumer;
import com.sxs.consumer.spring.boot.dubbo.pojo.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    //测试案例
    // http://localhost:7070/get/hello/msg?key=1
    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        String res = serviceConsumer.doSayHello(name);
        // 模拟异常
        // int i = 1/0;
        System.err.println("rpc调用返回结果： " +res);
        return res;
    }
    @GetMapping("/get/hello/msg")
    public Collection<HelloMessage> getHelloMsg(String key) {
        return serviceConsumer.getHelloMsg(key);
    }
   //测试案例
    /**
     * http://localhost:7070/post/hello/msg
     * {
     * 	"key":"sxs",
     * 	"value":"beautiful",
     * 	"score":"1.2"
     * }
     */
    @PostMapping("/post/hello/msg")
    public boolean setHelloMsg(@RequestBody HelloMessage message) {
        return serviceConsumer.setHelloMsg(message);
    }
}
