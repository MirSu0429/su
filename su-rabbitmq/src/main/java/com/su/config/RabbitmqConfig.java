package com.su.config;

import com.su.util.RabbitKeys;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: supengfei
 * @Date: 2019/1/26 10:36
 * @Description:
 */
@Configuration
public class RabbitmqConfig {


    /**
     * @Description Direct 模式
     * @Param
     * @return
     **/
    @Bean
    public Queue getQueue(){
        return new Queue(RabbitKeys.directMessage);
    }
    //===============以下是验证topic Exchange的队列==========
    /**
     * @Description Topic Exchange 模式
     * @Param 
     * @return 
     **/
    @Bean("queueMessage")
    public Queue getTopicMessageQueue(){
        return new Queue(RabbitKeys.topicMessage);
    }
    @Bean("queueMessages")
    public Queue getTopicMessageQueues(){
        return new Queue(RabbitKeys.topicMessages);
    }

    @Bean
    public TopicExchange getTopicExchange() {
        return new TopicExchange(RabbitKeys.exchange);
    }
    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingTopicExchange(Queue queueMessage,TopicExchange exchange ){
        return BindingBuilder.bind(queueMessage).to(exchange).with(RabbitKeys.binding_key);
    }
    /**
     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     * @param queueMessages
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingTopicExchanges(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with(RabbitKeys.binding_keys);
    }
    //===============以上是验证topic Exchange的队列==========

    //===============以下是验证Fanout Exchange的队列==========
    /**
     * @Description Fanout Exchange 模式 //pub sub
     * @Param 
     * @return 
     **/
    @Bean("fanoutQueueA")
    public Queue fanoutQueueA() {
        return new Queue(RabbitKeys.fanout_keyA);
    }
    @Bean("fanoutQueueB")
    public Queue fanoutQueueB() {
        return new Queue(RabbitKeys.fanout_keyB);
    }
    @Bean("fanoutQueueC")
    public Queue fanoutQueueC() {
        return new Queue(RabbitKeys.fanout_keyC);
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitKeys.fanoutExchange);
    }
    @Bean
    Binding bindingFanoutExchangeA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }
    @Bean
    Binding bindingFanoutExchangeB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }
    @Bean
    Binding bindingFanoutExchangeC(Queue fanoutQueueC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueC).to(fanoutExchange);
    }
    //===============以上是验证Fanout Exchange的队列==========
}
