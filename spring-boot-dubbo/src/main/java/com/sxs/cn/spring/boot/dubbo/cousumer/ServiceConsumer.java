package com.sxs.cn.spring.boot.dubbo.cousumer;

import com.sxs.cn.spring.boot.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;

/**
 * @ClassName: ServiceConsumer
 * @Description: 消费端实现
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */

public class ServiceConsumer {

    @Reference(url = "dubbo://127.0.0.1:12345")

    private HelloService helloService;

    public String doSayHello(String name) {
        return helloService.sayHello(name);
    }
}