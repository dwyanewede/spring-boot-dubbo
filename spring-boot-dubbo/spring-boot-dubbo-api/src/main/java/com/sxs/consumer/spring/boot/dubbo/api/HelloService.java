package com.sxs.consumer.spring.boot.dubbo.api;

import com.sxs.consumer.spring.boot.dubbo.pojo.HelloMessage;

import java.util.Collection;

/**
 * @ClassName: HelloService
 * @Description: 自定义RPC框架接口类
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */
public interface HelloService {

    String sayHello(String name);

    Collection<HelloMessage> getHelloMsg(String key);

    boolean setHelloMsg(HelloMessage message);
}
