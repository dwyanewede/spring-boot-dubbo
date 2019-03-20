package com.sxs.cn.spring.boot.dubbo.service;

import com.sxs.consumer.spring.boot.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @ClassName: DefaultService
 * @Description: HelloService默认实现
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */

@Service
public class DefaultService implements HelloService {
    // 省略实现，保持不变
    @Override
    public String sayHello(String name) {
        System.err.println("rpc调用收到的数据请求： " +name);
        return "Hello " + name;
    }

}