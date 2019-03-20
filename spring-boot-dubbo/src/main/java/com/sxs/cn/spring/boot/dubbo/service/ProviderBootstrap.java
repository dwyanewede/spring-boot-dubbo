package com.sxs.cn.spring.boot.dubbo.service;

import com.sxs.cn.spring.boot.dubbo.api.HelloService;
import com.sxs.cn.spring.boot.dubbo.configure.ProviderConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: ProviderBootstrap
 * @Description: 服务端引导类
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */
public class ProviderBootstrap {

    public static void main(String[] args) {
        // 创建 Annotation 配置上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册配置 Bean
        context.register(ProviderConfiguration.class);
        // 启动上下文
        context.refresh();
        // 获取 DemoService Bean
        HelloService demoService = context.getBean(HelloService.class);
        // 执行 sayHello 方法
        String message = demoService.sayHello("World");
        // 控制台输出信息
        System.err.println(message);
    }
    
}