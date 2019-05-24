package com.su.rabbitMQ;

import com.su.entity.JobEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author: supengfei
 * @Date: 2019/1/26 11:31
 * @Description:
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRabbitMQ {
   /* @Autowired
    private IRabbitProducerService rabbitProducerService;

    @Test
    public void directTest(){
        for (int i = 0; i < 10; i++) {

          //rabbitProducerService.sendDirectMessage("----direct----" );
            JobEntity jobEntity = new JobEntity();
            jobEntity.setJobName("测试" + i);
            rabbitProducerService.sendDirectMessage(jobEntity.toString());
        }
    }

    @Test
    public void topicTest() {
        rabbitProducerService.sendTopicMessage("我以指定key发送了一条消息");
    }

    @Test
    public void topicTest2() {
        rabbitProducerService.sendTopicMessages("我以统配符发送了一条消息");
    }
    @Test
    public void fanoutTest() {
        rabbitProducerService.sendFanoutMessage("我发送了一条广播消息");
    }*/
}
