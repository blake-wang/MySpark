package redis.sortSet;

import java.util.Random;

import redis.clients.jedis.Jedis;

/**
 * Created by wanglei on 2017/5/19.
 */
public class Sale
        implements Runnable
{
    //店铺销售排行榜
    private static final String   amountBang  = "tmall:amountBang";
    //店铺订单排行榜
    private static final String   orderBang   = "tmall:orderBang";
    //店铺名称
    private static final String[] shops       = new String[]{"小米",
                                                             "华为",
                                                             "魅族",
                                                             "苹果",
                                                             "联想",
                                                             "奇酷",
                                                             "中兴",
                                                             "一加",
                                                             "oppo"};
    //redis客户端
    private              Jedis    jedis       = new Jedis("127.0.0.1", 6379);
    //随机获取店铺
    private              Random   random      = new Random();
    //随机计算价格
    private              Random   priceRandom = new Random();


    public void run() {
        while (true) {
            try {
                int shopIndex = random.nextInt(shops.length);
                jedis.zincrby(amountBang, priceRandom.nextInt(2500), shops[shopIndex]);
                jedis.zincrby(orderBang, 1, shops[shopIndex]);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}
