package com.sxs.consumer.spring.boot.dubbo;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class SpringBootDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboConsumerApplication.class, args);
    }

}
