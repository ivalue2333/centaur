package tools.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 13722 on 2017/11/1.
 */
public class RedisDemo {

    Jedis jedis;

    public void testKey() {
        System.out.println(jedis.exists("name"));
        System.out.println(jedis.type("name"));
    }

    //批量删除以相同的字段开头的字符串
    public void testDelete(String str) {
        String pattern = str + "*";
        Set<String> strings = jedis.keys(pattern);

       try {
           for (String string : strings) {
               jedis.del(string);
           }
       }
       catch (Exception e) {
           e.printStackTrace();
           System.out.println("批量删除前缀字符串为" + str + "的操作失败");
       }
        System.out.println("批量删除成功");
    }

    //操作字符串
    public void testString() {
        List<String> mget = jedis.mget("name1", "name2");
        System.out.println(mget.get(0) + mget.get(1));
    }

    //操作哈希
    public void testHash() {
        Map<String, String> people = jedis.hgetAll("people");
        System.out.println(people.get("name") + "--" + people.get("password"));
        String hget = jedis.hget("people", "name");
        System.out.println(hget);
        List<String> hmget = jedis.hmget("people", "name", "password");
        System.out.println(hmget.get(0));
        System.out.println(hmget.get(1));
    }

    //操作列表
    public void testList() {
        jedis.lpush("db", "oracle");
        jedis.rpush("db","mongodb");
        List<String> db = jedis.lrange("db", 0, -1);
        for (int i = 0; i < db.size(); i ++) {
            System.out.println(db.get(i));
        }
    }

    //操作集合set（无序集合，在集合中的顺序和插入顺序没有必然联系）
    public void testSet() {
        jedis.sadd("course1","math", "chinese", "english");
        jedis.sadd("course2", "math", "physics", "chemistry");
        jedis.sunionstore("course", "course1", "course2");
        Set<String> course = jedis.smembers("course");
        Object[] objects = course.toArray();
        for (int i = 0; i < objects.length; i ++) {
            System.out.println(objects[i]);
        }
    }

    //操作集合zset（有序集合，通过分数来为集合数据从小到大排序）
    //由测试可以看出，排序由分数来决定
    public void testZset()  {
        jedis.zadd("course", 1, "math");
        jedis.zadd("course", 4, "Chinese");
        jedis.zadd("course", 3,"English");
        Set<Tuple> course = jedis.zrangeWithScores("course", 0, -1);
        for (Tuple tuple : course) {
            System.out.println(tuple.getElement() + "--" +  tuple.getScore());
        }

        //0 表示第一个元素， 1表示第二个元素
        Set<String> courses = jedis.zrange("course", 0, 1);
        for (String cour : courses) {
            System.out.println(cour);
        }
    }

    public void testHyperLogLog() {
        jedis.pfadd("db", "mysql", "sql", "redis");
        long db = jedis.pfcount("db");
        System.out.println(db);
    }

    //发布订阅
    public void testSubPub() {
        RedisSubPubDemo redisSubPubDemo = new RedisSubPubDemo();
        jedis.subscribe(redisSubPubDemo, "redisChat");
    }

    public void testTransaction() {

        //1 multi 开始一个事务
        Transaction multi = jedis.multi();
        //2 多个命令入队到事务
        multi.set("name", "kevin");
        multi.get("name");
        multi.sadd("course", "math", "English");
        multi.smembers("course");
        //3 触发事务，多个命令
        List<Object> exec = multi.exec();
        //0k, 和 2 是返回值
        System.out.println(exec);
        Object o = exec.get(3);
        System.out.println(o);
        HashSet<String> a = ( HashSet<String>) o;
        for (String a1 : a) {
            System.out.println(a1);
        }

    }


    public RedisDemo() {
        this.jedis = RedisUtil.getJedis();
    }

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }
}
