package com.efruit.micro.arkmanager.common;

import com.efruit.micro.arkmanager.BaseTest;
import com.efruit.micro.arkmanager.mq.RabbitMq4Push;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMqTest extends BaseTest {

    @Autowired
    RabbitMq4Push sender;

    @Test
    public void testSend() {
        sender.send("from test.");
    }

}
