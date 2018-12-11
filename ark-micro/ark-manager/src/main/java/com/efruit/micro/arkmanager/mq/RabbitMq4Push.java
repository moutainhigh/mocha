package com.efruit.micro.arkmanager.mq;

import org.springframework.stereotype.Component;

@Component
public class RabbitMq4Push extends BaseRabbitMq {

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected String getExchangeName() {
        return MqConfig.YOUZAN_PUSH_EXCHANGE_NAME;
    }

    @Override
    protected String getQueueName() {
        return MqConfig.YOUZAN_PUSH_QUEUE_NAME;
    }

}
