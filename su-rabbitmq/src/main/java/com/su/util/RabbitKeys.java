package com.su.util;

/**
 * @Author: supengfei
 * @Date: 2019/1/26 14:48
 * @Description:
 */
public interface RabbitKeys {
    /**
     * direct 模式 发送的key
     **/
    String directMessage = "direct.message";
    /**
     * topic 模式 发送的key
     **/
    String topicMessage = "topic.message";
    String topicMessages = "topic.messages";
    /**
     * 路由名称
     **/
    String exchange = "exchange";
    /**
     * 绑定规则
     **/
    String binding_key = "topic.message";
    String binding_keys = "topic.#";
    /**
     * fanout 模式
     **/
    String fanout_keyA = "fanout.messageA";
    String fanout_keyB = "fanout.messageB";
    String fanout_keyC = "fanout.messageC";

    String fanoutExchange = "fanoutExchange";
}
