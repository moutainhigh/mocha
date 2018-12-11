package com.efruit.micro.arkmanager.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BaseRabbitMq {

    private static final Logger logger = LoggerFactory.getLogger(BaseRabbitMq.class);

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        DirectExchange exchange = new DirectExchange(getExchangeName());
        exchange.setDelayed(true);
        Queue queue = new Queue(getQueueName());
        Binding binding = BindingBuilder.bind(queue).to(exchange).withQueueName();
        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareQueue(queue);
        amqpAdmin.declareBinding(binding);
    }

    protected abstract String getExchangeName();

    protected abstract String getQueueName();

    public final void send(String msg) {
        final String queueName = getQueueName();
        logger.info("{} -- 发送MQ消息:msg : {}", queueName, msg);
        rabbitTemplate.convertAndSend(queueName, msg);
    }

    public final void send(String msg, long delay) {
        final String queueName = getQueueName();
        logger.info("{} -- 发送MQ延时消息:msg : {}, delay : {}", queueName, msg, delay);
        rabbitTemplate.convertAndSend(getExchangeName(), queueName, msg, new MessagePostProcessor() {
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay((int) delay);
                return message;
            }
        });
    }

}
