package com.battery.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("redisDataSource")
@ConditionalOnBean(value=RedisConfig.class)
@AutoConfigureAfter(value=RedisConfig.class)
public class RedisDataSourceImpl implements RedisDataSource {

    private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);

    @Autowired
    private ShardedJedisPool    shardedJedisPool;

	public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            log.error("getRedisClent error", e);
            throw new RuntimeException("redis异常-->"+e);
        }
    }

    public void returnResource(ShardedJedis shardedJedis) {
//        shardedJedisPool.returnResource(shardedJedis);
    	shardedJedis.close();
    }

    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        if (broken) {
//            shardedJedisPool.returnBrokenResource(shardedJedis);
        	shardedJedis.close();
        } else {
//            shardedJedisPool.returnResource(shardedJedis);
        	shardedJedis.close();
        }
    }
}
