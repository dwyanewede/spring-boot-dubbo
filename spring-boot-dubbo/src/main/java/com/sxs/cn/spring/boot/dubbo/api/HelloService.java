package com.sxs.cn.spring.boot.dubbo.api;

/**
 * @ClassName: HelloService
 * @Description: 自定义RPC框架接口类
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */
public interface HelloService {
        String sayHello(String name);
}
