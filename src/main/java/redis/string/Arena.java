package redis.string;

import java.util.Random;

import redis.clients.jedis.Jedis;

/**
 * Created by wanglei on 2017/5/18.
 */
public class Arena
        implements Runnable
{
    private Random mRandom = new Random();
    private String mRedisKey;
    private Jedis  mJedis;
    private String mArenaName;

    public Arena(String redisKey, String arenaName) {
        this.mRedisKey = redisKey;
        this.mArenaName = arenaName;
    }

    public void run() {
        mJedis = new Jedis("127.0.0.1", 6379);
        String[] daxias = new String[]{"郭靖",
                                       "黄蓉",
                                       "令狐冲",
                                       "杨过",
                                       "林冲",
                                       "鲁智深",
                                       "小龙女",
                                       "虚竹",
                                       "独孤求败",
                                       "张三丰",
                                       "王重阳",
                                       "张无忌",
                                       "东方不败",
                                       "逍遥子",
                                       "乔峰",
                                       "段誉",
                                       "韦小宝",
                                       "王语嫣",
                                       "周赤若",
                                       "峨眉师太",
                                       "慕容复",};
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int p1 = mRandom.nextInt(daxias.length);
            int p2 = mRandom.nextInt(daxias.length);
            while (p1 == p2) {
                p2 = mRandom.nextInt(daxias.length);
            }
//            System.out.println("在擂台" + mArenaName + "上，大侠 <" + daxias[p1] + "> VS <" + daxias[p2] + ">");
            mJedis.incr(mRedisKey);

        }


    }

}
