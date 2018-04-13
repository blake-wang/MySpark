package redis.sortSet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanglei on 2017/5/19.
 */
public class Bang {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //创建销售线程-销售商品
        executorService.submit(new Sale());
        executorService.submit(new Sale());
        //创建报表线程-周期型计算排行榜
        executorService.submit(new BangView());
    }
}
