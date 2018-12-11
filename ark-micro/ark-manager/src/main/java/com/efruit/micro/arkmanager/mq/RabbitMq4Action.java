package com.efruit.micro.arkmanager.mq;

import org.springframework.stereotype.Component;

@Component
public class RabbitMq4Action extends BaseRabbitMq {

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected String getExchangeName() {
        return MqConfig.ACTION_PUSH_EXCHANGE_NAME;
    }

    @Override
    protected String getQueueName() {
        return MqConfig.ACTION_PUSH_QUEUE_NAME;
    }
}
