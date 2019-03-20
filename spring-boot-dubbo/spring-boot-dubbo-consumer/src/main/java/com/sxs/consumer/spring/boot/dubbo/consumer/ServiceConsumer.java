package com.sxs.consumer.spring.boot.dubbo.consumer;

import com.sxs.consumer.spring.boot.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;


/**
 * @ClassName: ServiceConsumer
 * @Description: 消费端实现
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */
public class ServiceConsumer{

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.err.println("-----------系统启动开始测试 dubbo rpc 调用结果--------------");
        System.err.println(helloService.sayHello("sxs"));
        System.err.println("-----------系统启动完成测试 dubbo rpc 调用结果--------------");
    }

    @Reference(url = "dubbo://192.168.125.1:12345")
    private HelloService helloService;

    public String doSayHello(String name) {
        return helloService.sayHello(name);
    }
}