package com.efruit.micro.arkmanager.mq;

import org.springframework.context.annotation.Configuration;


@Configuration
public class MqConfig {

    public static final String YOUZAN_PUSH_QUEUE_NAME = "youzan.push.queue";

    public static final String YOUZAN_PUSH_EXCHANGE_NAME = "youzan.push.exchange";

    public static final String ACTION_PUSH_QUEUE_NAME = "action.push.queue";

    public static final String ACTION_PUSH_EXCHANGE_NAME = "action.push.exchange";

    public static final String MESSAGE_PUSH_QUEUE_NAME = "message_push_queue_name";

    public static final String MESSAGE_PUSH_EXCHANGE_NAME = "message_push_exchange_name";

}
