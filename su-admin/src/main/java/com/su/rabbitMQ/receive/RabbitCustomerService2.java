package com.su.rabbitMQ.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.su.util.RabbitKeys;

/**
 * @Author: supengfei
 * @Date: 2019/1/26 11:35
 * @Description:
 */
@Component
public class RabbitCustomerService2 {

    @RabbitListener(queues = RabbitKeys.directMessage)
    public void receiveCustomer(Object msg){
        System.out.println("我接受到的消息2是:" + msg.toString());
    }
}
