package com.sxs.cn.spring.boot.dubbo;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@DubboComponentScan("com.sxs.cn.spring.boot.dubbo.service") // 扫描 Dubbo 组件
public class SpringBootDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboServiceApplication.class, args);
    }

}
