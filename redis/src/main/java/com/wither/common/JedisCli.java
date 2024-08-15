package com.wither.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 创建Jedis客户端
 */
public class JedisCli {
    private static final Log logger = LogFactory.getLog(JedisCli.class);
    private static String ip = "127.0.0.1";
    private static int port = 6379;
    //private static String password = "123456";
    private static int MAX_ACTIVE = 70000;
    private static int MAX_IDLE = 50000;
    private static int MAX_WAIT = 3000;
    private static int TIME_OUT = 3000;
    private static Jedis jedis = null;
    private static JedisPool jedisPool = null;

    private JedisCli(){}

    private static JedisCli getInstance(){
        return RedisHolder.instance;
    }

    /**
     * 获取Jedis客户端，加锁，避免并发操作
     * @return
     */
    public synchronized static Jedis getJedis(){
        if (jedisPool == null) {
            return null;
        }else {
            Jedis resource = jedisPool.getResource();
            return resource;
        }
    }

    /**
     * 释放Jedis
     * @param jedis
     */
    public void returnResource(Jedis jedis){
        if (jedis != null){
            jedis.close();
            //jedisPool.returnResource(jedis);
        }
    }

    /**
     * 内部类创建单例
     */
    private static class RedisHolder{
        private static JedisCli instance = new JedisCli();

        private RedisHolder(){}
    }


    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_ACTIVE);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);

        try {
            jedisPool = new JedisPool(config, ip, port, TIME_OUT);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("初始化Redis链接池异常");
        }

    }
}
