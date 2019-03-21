package com.sxs.consumer.spring.boot.dubbo.configure;

import com.sxs.consumer.spring.boot.dubbo.consumer.ServiceConsumer;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ConsumerConfiguration
 * @Description: 消费者配置信息
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */
@Configuration
//@DubboComponentScan
public class ConsumerConfiguration {


    @Value("${zookeeper.address}")
    private String zkAddress;
    @Value("${zookeeper.client}")
    private String zkClient;
    @Value("${dubbo.consumer.name}")
    private String consumerName;


    /**
     * 当前应用配置
     */
    @Bean("dubbo-consumer")
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(consumerName);
        return applicationConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(zkAddress);
        registryConfig.setClient(zkClient);
        return registryConfig;
    }

    /**
     * 注册 AnnotationDemoServiceConsumer，@DubboComponentScan 将处理其中 @Reference 字段。
     * 如果 AnnotationDemoServiceConsumer 非 Spring Bean 的话，
     * 即使 @DubboComponentScan 指定 package 也不会进行处理，与 Spring @Autowired 同理
     */
    @Bean
    public ServiceConsumer annotationDemoServiceConsumer() {
        return new ServiceConsumer();
    }

}