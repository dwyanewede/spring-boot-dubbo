package com.sxs.cn.spring.boot.dubbo.cousumer;

import com.sxs.cn.spring.boot.dubbo.configure.ConsumerConfiguration;
import com.sxs.cn.spring.boot.dubbo.configure.ProviderConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: ConsumerBootstrap
 * @Description: 服务消费端引导类
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */

public class ConsumerBootstrap {

    public static void main(String[] args) {
        // 启动服务提供方上下文
        startProviderContext();
        // 启动并且返回服务消费方上下文
        ApplicationContext consumerContext = startConsumerContext();
        // 获取 AnnotationDemoServiceConsumer Bean
        ServiceConsumer consumer = consumerContext.getBean(ServiceConsumer.class);
        // 执行 doSayHello 方法
        String message = consumer.doSayHello("World");
        // 输出执行结果
        System.err.println(message);
    }

    /**
     * 启动并且返回服务消费方上下文
     *
     * @return AnnotationConfigApplicationContext
     */
    private static ApplicationContext startConsumerContext() {
        // 创建服务消费方 Annotation 配置上下文
        AnnotationConfigApplicationContext consumerContext = new AnnotationConfigApplicationContext();
        // 注册服务消费方配置 Bean
        consumerContext.register(ConsumerConfiguration.class);
        // 启动服务消费方上下文
        consumerContext.refresh();
        // 返回服务消费方 Annotation 配置上下文
        return consumerContext;
    }

    /**
     * 启动服务提供方上下文
     */
    private static void startProviderContext() {
        // 创建 Annotation 配置上下文
        AnnotationConfigApplicationContext providerContext = new AnnotationConfigApplicationContext();
        // 注册配置 Bean
        providerContext.register(ProviderConfiguration.class);
        // 启动服务提供方上下文
        providerContext.refresh();
    }

}