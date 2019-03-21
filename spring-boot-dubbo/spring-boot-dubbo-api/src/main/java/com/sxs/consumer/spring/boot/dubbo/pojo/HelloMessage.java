package com.sxs.consumer.spring.boot.dubbo.pojo;

import java.io.Serializable;

/**
 * @ClassName: HelloMessage
 * @Description: Hello实体类
 * @Author: 尚先生
 * @CreateDate: 2019/3/21 22:06
 * @Version: 1.0
 */
public class HelloMessage implements Serializable {

    private static final long serialVersionUID = 1734871707511255626L;

    /** 消息key **/
    private String key;

    /** 消息value **/
    private String value;

    /** 消息权重 **/
    private Double score;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "HelloMessage 实体信息：{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", score=" + score +
                '}';
    }
}
