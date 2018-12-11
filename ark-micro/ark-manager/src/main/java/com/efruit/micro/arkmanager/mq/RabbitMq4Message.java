package com.efruit.micro.arkmanager.mq;

import org.springframework.stereotype.Component;

@Component
public class RabbitMq4Message extends BaseRabbitMq {

    @Override
    protected String getExchangeName() {
        return MqConfig.MESSAGE_PUSH_EXCHANGE_NAME;
    }

    @Override
    protected String getQueueName() {
        return MqConfig.MESSAGE_PUSH_QUEUE_NAME;
    }

}
