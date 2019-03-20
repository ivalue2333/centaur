package tools.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by 13722 on 2017/8/31.
 */
public class RedisUtil {

    public static Jedis getJedis() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("chh123");
        System.out.println("连接成功");
        return jedis;
    }
}

