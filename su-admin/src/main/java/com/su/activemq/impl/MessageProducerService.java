package com.su.activemq.impl;

import com.su.activemq.IMessageProducerService;
import org.springframework.stereotype.Service;

/**
 * @Author: supengfei
 * @Date: 2019/1/23 10:16
 * @Description:
 */
@Service
public class MessageProducerService implements IMessageProducerService {
    @Override
    public void sendQueueMessage(String msg) {

    }

    @Override
    public void sendTopicMessage(String msg) {

    }
/*
    @Autowired
    private Destination destination;
    @Autowired
    private Topic topic;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendQueueMessage(String msg) {
        jmsTemplate.convertAndSend(destination,msg);
    }

    @Override
    public void sendTopicMessage(String msg) {
        jmsTemplate.convertAndSend(topic,msg);
    }*/
}
