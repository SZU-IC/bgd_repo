package com.wither;

import com.wither.common.JedisCli;
import com.wither.handle.HandleDB;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestRedis {

    @Test
    public void testJedis(){
        Jedis jedis = JedisCli.getJedis();
        jedis.set("comp", "视野");
        jedis.close();
    }

    @Test
    public void testSetValue(){
        Jedis jedis = JedisCli.getJedis();
        HandleDB handleDB = new HandleDB(jedis);

        String string = handleDB.setValue("lega", "wither");
        System.out.println("string = " + string);
    }
}
