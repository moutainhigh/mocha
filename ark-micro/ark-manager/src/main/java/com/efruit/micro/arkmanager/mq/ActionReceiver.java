package com.efruit.micro.arkmanager.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = MqConfig.ACTION_PUSH_QUEUE_NAME)
public class ActionReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActionReceiver.class);

    @RabbitHandler
    public void onMessage(String tid) {
        LOGGER.info("onMessage() tid : {}", tid);
    }

}
