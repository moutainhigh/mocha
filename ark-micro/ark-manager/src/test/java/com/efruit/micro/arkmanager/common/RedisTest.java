package com.efruit.micro.arkmanager.common;

import com.efruit.micro.arkmanager.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisTest extends BaseTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("aa@126.com", "aa");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        final String redisKey = "hello.redis";
        operations.set(redisKey, user);
//        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
//        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey(redisKey);
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }

        final User fromRedis = operations.get(redisKey);
        Assert.assertEquals("aa", fromRedis.getDec());
    }

    private static class User {
        private String name;
        private String dec;

        public User() {
        }

        public User(String name, String dec) {
            this.name = name;
            this.dec = dec;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDec() {
            return dec;
        }

        public void setDec(String dec) {
            this.dec = dec;
        }
    }
}
