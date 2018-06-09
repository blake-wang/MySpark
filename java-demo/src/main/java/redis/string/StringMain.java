package redis.string;

import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * Created by wanglei on 2017/5/18.
 */
public class StringMain {
    public static void main(String[] args) {
        //创建jedis客户端
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //操作一个String字符串
        jedis.set("name", "liudehua");//插入一个名字，叫做刘德华
        System.out.println(jedis.get("name"));

        //对String类型数据进行增减，前提是kv对应的值是数字
        jedis.set("age", "17");//给用户刘德华设置年龄，17岁
        jedis.incr("age");//让用户刘德华年龄增加一岁
        System.out.println(jedis.get("age"));
        jedis.decr("age");//让刘德华年轻一岁
        System.out.println(jedis.get("age"));//在18岁的基础上年轻一岁，变回17岁

        //一次性插入多条数据，为江湖大侠设置绝杀技能
        jedis.mset("A", "MYSQL数据库操作", "B", "熟悉Linux操作系统", "C", "熟悉SSH框架及配置", "D", "熟悉Spring框架");
        List<String> results = jedis.mget("A", "B", "C", "D");
        for (String value : results) {
            System.out.println(value);
        }

        //设置字段的自动过期
        jedis.setex("wumai", 10, "我们活在仙境中");//让仙境保持10秒钟
        while (jedis.exists("wumai")) {
            System.out.println("真是天上人间啊！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("----------------------------");
        //对已经存在的字段设置过期时间
        jedis.set("wumai", "我们活在仙境中");
        jedis.expire("wumai", 10);//让天上人间的感觉保持更长时间
        while (jedis.exists("wumai")) {
            System.out.println("真是天上人间啊！！！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
