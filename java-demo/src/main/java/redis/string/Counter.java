package redis.string;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanglei on 2017/5/18.
 */
public class Counter {
    public static void main(String[] args) {
        //创建一个固定大小的线程池，3个擂台
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //擂台1：天龙八部
        executorService.submit(new Arena("biwu:totalNum", "天龙八部"));
        //擂台2：神雕侠侣
        executorService.submit(new Arena("biwu:totalNum", "神雕侠侣"));
        //擂台3：倚天屠龙记
        executorService.submit(new Arena("biwu:totalNum", "倚天屠龙记"));
        //报幕人员，一秒统计一次总共比了多少场
        executorService.submit(new BaoMu("biwu:totalNum"));
    }
}
