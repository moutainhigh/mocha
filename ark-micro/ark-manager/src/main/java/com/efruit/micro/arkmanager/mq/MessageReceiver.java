package com.efruit.micro.arkmanager.mq;

import com.alibaba.fastjson.JSON;
import com.efruit.micro.arkmanager.bean.MessageEntity;
import com.efruit.micro.arkmanager.service.DispatchingSendMessageService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = MqConfig.MESSAGE_PUSH_QUEUE_NAME)
public class MessageReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

    @Autowired
    DispatchingSendMessageService sendMessageService;

    @RabbitHandler
    public void onMessage(String msgJson) {
        LOGGER.info("onMessage() msgJson : {}", msgJson);
        if (StringUtils.isEmpty(msgJson)) {
            return;
        }

        final MessageEntity messageEntity = JSON.parseObject(msgJson, MessageEntity.class);
        sendMessageService.processMessageSend(messageEntity);
    }

}
