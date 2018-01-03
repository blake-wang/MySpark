package redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;

/**
 * Created by bigdata on 18-1-3.
 * redis各种操作
 * redis默认有16个库，编号为 0～15
 * 一般都是一个jedis对象选择一个库
 * <p>
 * 注意事项：
 * 1、对同样的键赋值，会将原来的值覆盖掉
 */
public class redisDemo {


    public static void main(String[] args) {
        JedisPool jedisPool = getJedisPool();
        //获取一个jedis对象,选择11号库
        Jedis jedis11 = jedisPool.getResource();
        jedis11.select(11);
        //获取一个jedis对象,选择12号库
        Jedis jedis12 = jedisPool.getResource();
        jedis12.select(12);

//        setAndGet(jedis11);
        hsetAndhget(jedis11);
//        msetAndmget(jedis11);
//        hmsetAndhmget(jedis11);


    }

    /**
     * hmset and hmget and hgetall
     * hmset:一次可以存储 key-map  ,map是一个兼职对集合
     * hmget:一次可以取出 key下对应的多个field的value，返回的是value的集合
     * hgetall:一次可以取出 key下对应的所有field-value,返回的是map集合
     *
     * @param jedis11
     */
    private static void hmsetAndhmget(Jedis jedis11) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "aixu");
        map.put("age", "18");
        map.put("sex", "male");
        map.put("level", "yanjiusheng");
        String people = jedis11.hmset("people", map);
        System.out.println(people);

        System.out.println("------------------------------");
        //hmget
        List<String> hmget = jedis11.hmget("people", "name", "age", "sex", "level");
        for (String s : hmget) {
            System.out.println(s);
        }

        System.out.println("------------------------------");
        //hgetall
        Map<String, String> people1 = jedis11.hgetAll("people");
        for (Map.Entry<String, String> entry : people1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * mset and mget
     * 一次可以设置多个key-value
     * mset:一次存储多个key-value
     * mget:一次取出多个key对应的value，返回的是一个List
     *
     * @param jedis11
     */
    private static void msetAndmget(Jedis jedis11) {
        String mset = jedis11.mset("1", "1", "2", "2", "3", "3");
        System.out.println(mset);

        System.out.println("------------------------------");
        List<String> mget = jedis11.mget("1", "2");
        for (String s : mget) {
            System.out.println(s);
        }
        System.out.println("------------------------------");
    }

    /**
     * hset and hget and hgetall
     * <p>
     * 一个键下面可以有多个字段，每个字段都有一个值
     * hset:每次存储一个 key-field-value
     * hget:每次取出一个 key-field 对应的值
     * hgetall:取出key下的所有field-value,返回的是一个 Map
     *
     * @param jedis11
     */
    private static void hsetAndhget(Jedis jedis11) {
        //hset
        Long hset = jedis11.hset("zhongguo", "guangdong", "guangzhou");
        System.out.println(hset);
        //hget
        String hget = jedis11.hget("zhongguo", "guangdong");
        System.out.println(hget);


        System.out.println("------------------------------");

        jedis11.hset("zhongguo", "shanxi", "xian");
        jedis11.hset("zhongguo", "henan", "zhengzhou");
        jedis11.hset("zhongguo", "jiangsu", "nanjing");

        Map<String, String> zhongguo = jedis11.hgetAll("zhongguo");
        System.out.println(zhongguo.get("shanxi"));
        System.out.println(zhongguo.get("henan"));
        System.out.println(zhongguo.get("jiangsu"));
        System.out.println("------------------------------");
        Iterator<String> keyIterator = zhongguo.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.println("key : " + key);
        }
        System.out.println("------------------------------");
        Iterator<String> valueIterator = zhongguo.values().iterator();
        while (valueIterator.hasNext()) {
            String value = valueIterator.next();
            System.out.println("value : " + value);
        }

        System.out.println("------------------------------");
        for (String fields : zhongguo.keySet()) {
            System.out.println(zhongguo.get(fields));
        }
        System.out.println("------------------------------");
        for (String s : zhongguo.values()) {
            System.out.println(s);
        }
        System.out.println("------------------------------");
        for (Map.Entry<String, String> entry : zhongguo.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * set and get
     * 单键和单值
     * set:每次存储一个 key-value
     * get:每次取出一个 key 对应的值
     *
     * @param jedis11
     */
    private static void setAndGet(Jedis jedis11) {
        String set = jedis11.set("name", "wanglei");
        System.out.println(set);
        String name = jedis11.get("name");
        System.out.println("name : " + name);
    }


    /**
     * 获取redis连接池
     *
     * @return
     */
    public static JedisPool getJedisPool() {
        //redis相关配置
        String host = "192.168.20.177";
        int port = 6379;
        int maxIdle = 50;
        int maxTotal = 1000;
        int maxWaitMillis = 10000;

        //连接池配置设置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        //最大空闲连接数
        poolConfig.setMaxIdle(100);
        //连接池的最大连接数
        poolConfig.setMaxTotal(100);
        //设置获取连接的最大等待时间
        poolConfig.setMaxWaitMillis(2000);
        //从连接池中获取连接的时候是否需要校验，这样可以保证取出的连接都是可用的
        poolConfig.setTestOnBorrow(true);
        //获取jedis连接池
        return new JedisPool(poolConfig, host, port, 30000, "redis");
    }
}
