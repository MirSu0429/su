package com.su.rabbitMQ.receive;

import com.su.util.RabbitKeys;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: supengfei
 * @Date: 2019/1/26 14:53
 * @Description:
 */
@Component
public class TopicCustomerService {

    @RabbitListener(queues = RabbitKeys.topicMessage)
    public void receiveTopic(Object msg){
        System.out.println("topic 指定key接受到的"+ msg.toString());
    }
}
