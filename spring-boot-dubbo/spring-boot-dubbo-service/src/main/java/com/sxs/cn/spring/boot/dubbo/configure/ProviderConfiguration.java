package com.sxs.cn.spring.boot.dubbo.configure;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.SimpleTransactionStatus;

/**
 * @ClassName: ProviderConfiguration
 * @Description: 服务提供方配置信息
 * @Author: 尚先生
 * @CreateDate: 2019/3/20 18:50
 * @Version: 1.0
 */
@Configuration
public class ProviderConfiguration {

    @Value("${zookeeper.address}")
    private String zkAddress;
    @Value("${zookeeper.client}")
    private String zkClient;
    @Value("${dubbo.provier.name}")
    private String providerName;
    @Value("${dubbo.provier.owner}")
    private String providerOwner;
    @Value("${dubbo.protocol.name}")
    private String protocolName;
    @Value("${dubbo.protocol.port}")
    private int protocolPort;

    /**
     * 当前应用配置
     */
    @Bean("dubbo-provider")
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(providerName);
        applicationConfig.setOwner(providerOwner);
        return applicationConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean("my-registry")
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(zkAddress);
        registryConfig.setClient("curator");
        return registryConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean("dubbo")
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(protocolPort);
        return protocolConfig;
    }

    /**
     * 自定义事务管理器
     */
    @Bean
    @Primary
    public PlatformTransactionManager transactionManager() {
        return new PlatformTransactionManager() {

            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                System.out.println("get transaction ...");
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("commit transaction ...");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {
                System.out.println("rollback transaction ...");
            }
        };
    }
}