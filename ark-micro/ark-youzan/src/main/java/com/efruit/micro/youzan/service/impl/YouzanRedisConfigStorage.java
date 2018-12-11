package com.efruit.micro.youzan.service.impl;

import com.efruit.micro.youzan.service.YouzanConfigStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class YouzanRedisConfigStorage implements YouzanConfigStorage {

    private final static String TOKEN_JSON_KEY = "youzan_token_json";

    /**
     * 使用连接池保证线程安全
     */
    @Autowired
    private JedisPool jedisPool;

    @Override
    public synchronized void setTokenJson(String tokenJson) {
        try (Jedis jedis = this.jedisPool.getResource()) {
            jedis.set(TOKEN_JSON_KEY, tokenJson);
        }
    }

    @Override
    public String getTokenJson() {
        try (Jedis jedis = this.jedisPool.getResource()) {
            return jedis.get(TOKEN_JSON_KEY);
        }
    }
}
