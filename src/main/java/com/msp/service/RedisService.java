package com.msp.service;

import org.apache.ibatis.javassist.tools.rmi.StubGenerator;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void setHash(String key, String filedkey, String value){
        stringRedisTemplate.opsForHash().put(key, filedkey, value);
    }

    public String getHash(String key, String filedkey){
        return (String)stringRedisTemplate.opsForHash().get(key, filedkey);
    }

    public void setList(String key, String value){
        stringRedisTemplate.opsForList().leftPush(key, value);
    }

    public List<String > getList(String key, long start, long end){
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

}
