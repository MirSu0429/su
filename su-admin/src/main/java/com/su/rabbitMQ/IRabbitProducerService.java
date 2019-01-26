package com.su.rabbitMQ;

/**
 * @Author: supengfei
 * @Date: 2019/1/26 11:19
 * @Description:
 */
public interface IRabbitProducerService {
    /**
     * @Description //TODO Direct 模式 点对点
     * @Param 
     * @return
     **/
    void sendDirectMessage(Object msg);

    /**
     * @Description //TODO  topic 路由模式
     * @Param
     * @return
     **/
    void sendTopicMessage(Object msg);
    void sendTopicMessages(Object msg);

    /**
     * @Description //TODO fanout路由模式 pub sub
     * @Param
     * @return
     **/
    void sendFanoutMessage(Object msg);
}
