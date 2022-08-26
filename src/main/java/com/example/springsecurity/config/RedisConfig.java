package com.example.springsecurity.config;

import com.example.springsecurity.utils.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings(value = {"unchecked","rawtypes"})
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        //为了方便 直接采用<String,Object> 默认为<Object,Object>
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //序列化配置
        FastJsonRedisSerializer serializer = new FastJsonRedisSerializer(Object.class);
        //key采用String序列化的方式
        template.setKeySerializer(new StringRedisSerializer());
        //hash的key也采用String的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        //value采用jackson的序列化方式
        template.setValueSerializer(serializer);
        //hash的value采用jackson的序列化方式
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

}
