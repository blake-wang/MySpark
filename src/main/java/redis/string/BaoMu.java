package redis.string;

import redis.clients.jedis.Jedis;

/**
 * Created by wanglei on 2017/5/18.
 */
public class BaoMu
        implements Runnable
{
    private Jedis  mJedis;
    private String mRedisKey;

    public BaoMu(String redisKey) {
        mRedisKey = redisKey;
    }


    public void run() {
        mJedis = new Jedis("127.0.0.1", 6379);
        while (true) {
            try {
                Thread.sleep(10);
                System.out.println("<报幕> 当前总共比武次数为： " + mJedis.get(mRedisKey));
            } catch (InterruptedException e) {
                System.out.println("擂台被损坏！！！！！");
            }
        }
    }
}
