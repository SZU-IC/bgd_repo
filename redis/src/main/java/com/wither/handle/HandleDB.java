package com.wither.handle;

import redis.clients.jedis.Jedis;

public class HandleDB {
    private Jedis jedis = null;

    public HandleDB(Jedis jedis){
        this.jedis = jedis;
    }

    public String setValue(String key, String value){
        String s = jedis.set(key, value);
        return s;
    }

}
