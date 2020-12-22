package com.web.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author zhourui
 * @Date 2020/12/16 16:07
 */
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
}
