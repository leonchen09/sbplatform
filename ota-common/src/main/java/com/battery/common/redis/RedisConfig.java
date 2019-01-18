package com.battery.common.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;


/**
 * @author zhangjia
 *
 */
@Configuration
public class RedisConfig{

    @Value("${redis.host}")
    private String hostName;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.pass:#{null}}")
    private String password;
    
    @Value("${redis.max.total}")
    private int maxTotal;
    
    @Value("${redis.max.idle}")
    private int maxIdle;

    @Value("${redis.max.waitMillis}")
    private long maxWait;

    @Value("${redis.test.on_borrow}")
    private boolean testOnBorrow;

    @Bean(name="jedisPoolConfig")
    public JedisPoolConfig configJedisPoolConfig(){
        JedisPoolConfig config =  new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWait);
        config.setTestOnBorrow(testOnBorrow);
        return config;
    }
    
    @Bean(name="shardedJedisPool")
    public ShardedJedisPool configShardedJedisPool() {
    	JedisShardInfo jedisShardInfo = new JedisShardInfo(hostName,port);
    	jedisShardInfo.setPassword(password);
    	ShardedJedisPool shardedJedisPool = new ShardedJedisPool(configJedisPoolConfig(), Lists.newArrayList(jedisShardInfo));
    	return shardedJedisPool;
    }
}