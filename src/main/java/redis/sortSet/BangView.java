package redis.sortSet;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Created by wanglei on 2017/5/19.
 */
public class BangView
        implements Runnable
{
    //店铺销售排行榜
    private static final String amountBang = "tmall:amountBang";
    //店铺订单排行榜
    private static final String orderBang  = "tmall:orderBang";
    //redis客户端
    private              Jedis  jedis      = new Jedis("127.0.0.1", 6379);

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("==============店铺销售额排行==============================");
                Set<String> names = jedis.zrevrange(amountBang, 0, 4);
                for (String name : names) {
                    System.out.println(name + "         " + jedis.zrevrank(amountBang,
                                                                           name) + "            " + jedis.zscore(
                            amountBang,
                            name));
                }
                System.out.println("==============店铺订单量排行==============================");
                names = jedis.zrevrange(orderBang, 0, 4);
                for (String name : names) {
                    System.out.println(name + "         " + jedis.zrevrank(orderBang,
                                                                           name) + "            " + jedis.zscore(
                            orderBang,
                            name));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
