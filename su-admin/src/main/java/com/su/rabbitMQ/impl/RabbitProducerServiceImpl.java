package com.su.rabbitMQ.impl;

import com.su.rabbitMQ.IRabbitProducerService;
import com.su.util.RabbitKeys;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: supengfei
 * @Date: 2019/1/26 11:22
 * @Description:
 */
@Service("rabbitProducerService")
public class RabbitProducerServiceImpl implements IRabbitProducerService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    public void sendDirectMessage(Object msg) {
        this.amqpTemplate.convertAndSend(RabbitKeys.directMessage,msg);
    }

    @Override
    public void sendTopicMessage(Object msg) {
        this.amqpTemplate.convertAndSend(RabbitKeys.exchange, RabbitKeys.topicMessage,msg);
    }

    @Override
    public void sendTopicMessages(Object msg) {
        this.amqpTemplate.convertAndSend(RabbitKeys.exchange, RabbitKeys.topicMessages,msg);
    }

    @Override
    public void sendFanoutMessage(Object msg) {
        this.amqpTemplate.convertAndSend(RabbitKeys.fanoutExchange,"",msg);
    }
}
