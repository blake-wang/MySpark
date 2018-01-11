package base.object;

import java.util.Date;

/**
 * Created by wanglei on 2018/1/4.
 * Date类  日期类
 * <p>
 * java.util.Date
 * java.sql.Date
 * <p>
 * 我们使用的都是 java.util.Date  这个 ,绝对不能导入 java.sql.Date 这个
 * Date 表示特定的瞬间，精确到毫秒
 * <p>
 * 构造函数
 * public Date()
 * public Date(long date)
 * <p>
 * 成员方法
 * public long getTime()
 * public void setTime(long time)
 */
public class DateDemo {
    public static void main(String[] args) {
        Date d1 = new Date();        //如果没有传参数，代表的是当前时间
        System.out.println(d1);

        Date d2 = new Date(0);  //如果构造方法中传入0，代表的是1970年1月1日
        System.out.println(d2);


        //getTime()     获取当前时间的毫秒值
        long time = d1.getTime();
        System.out.println(time);

        //setTime()     设置毫秒值，改变时间对象
        d1.setTime(1000);
        System.out.println(d1);


        //通过传入时间戳构建Date对象，默认接受的是以毫秒为单位的
        Date d3 = new Date(1514185005000L);
        System.out.println(d3);


    }
}
