package com.sxs.cn.spring.boot.dubbo.service;

import com.sxs.cn.spring.boot.dubbo.utils.RedisUtil;
import com.sxs.consumer.spring.boot.dubbo.api.HelloService;
import com.sxs.consumer.spring.boot.dubbo.pojo.HelloMessage;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @ClassName: DefaultService
 * @Description: HelloService默认实现
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */

@Service
public class DefaultService implements HelloService {

    // 第一种：采用redis实现数据缓存
    @Autowired
    private RedisUtil redisUtil;

    // 第二种：采用内存存储
    private ConcurrentHashMap<String,HelloMessage> DBMap = new ConcurrentHashMap<>();

    private AtomicInteger DBIndex = new AtomicInteger(0);

    // 省略实现，保持不变
    @Override
    public String sayHello(String name) {
        System.err.println("rpc调用收到的数据请求： " +name);
        return "Hello " + name;
    }

    // sortSet方式存取数据
    //Set<Object> value = redisUtil.getSorted(key,0,-1);
    @Override
    public Collection<HelloMessage> getHelloMsg(String key) {
        HelloMessage helloMessage;
        Object redisResult = redisUtil.get(key);
        if (null == redisResult){
            helloMessage = DBMap.get(key);
        }else {
            helloMessage = (HelloMessage) redisResult;
        }

        return Collections.singleton(helloMessage);
    }

    // sortSet方式存取数据
    //redisUtil.setSorted(message.getKey(),message.getValue(),message.getScore());
    @Override
    public boolean setHelloMsg(HelloMessage message) {
        String key = String.valueOf(DBIndex.addAndGet(1));
        boolean redisResult = false;
        if (!DBMap.containsKey(key)){
            DBMap.put(key,message);
            redisResult = redisUtil.set(key, message);
        }
        return redisResult;
    }

}