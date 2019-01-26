package com.su.rabbitMQ.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.su.util.RabbitKeys;

/**
 * @Author: supengfei
 * @Date: 2019/1/26 14:53
 * @Description:
 */
@Component
public class TopicCustomerService2 {

    @RabbitListener(queues = RabbitKeys.topicMessages)
    public void receiveTopic(Object msg){
        System.out.println("topic 通配符方式接受到的"+ msg.toString());
    }
}
