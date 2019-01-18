package com.battery.core.util;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

public class RabbitmqUtils {
    private static final String EXCHANGE = "datahub.topic";

    /**
     * 发送mq延迟消息
     * @param template
     * @param body
     * @param routingKey
     * @param delayTime
     */
    public static void sendDelayMessage2Mq(RabbitTemplate template, byte[] body, String routingKey, Integer delayTime){
        MessageProperties properties = new MessageProperties();
        properties.setDelay(delayTime);
        Message message = new Message(body,properties);
        template.send(EXCHANGE,routingKey,message);
    }
    /**
     * 发送即时mq消息
     * @param template
     * @param body
     * @param routingKey
     */
    public static void sendMessage2Mq(RabbitTemplate template, byte[] body, String routingKey, CorrelationData correlationData)
    {
        template.setEncoding("UTF-8");
        Message message = new Message(body,new MessageProperties());
        template.convertAndSend(EXCHANGE,routingKey,message,correlationData);
    }
}
