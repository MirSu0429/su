package com.su.rabbitMQ.receive;

import com.su.util.RabbitKeys;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: supengfei
 * @Date: 2019/1/26 15:30
 * @Description:
 */
@Component
public class FanoutCustomerService {

    @RabbitListener(queues = RabbitKeys.fanout_keyA)
    public void receiveFanoutMessage(Object msg) {
        System.out.println("fanout --A--  接收到的消息"+msg);
    }
}
