package base.object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanglei on 2018/1/4.
 * SimpleDateFormat类
 * <p>
 * 日期格式化
 */
public class SimpleDateFormatDemo {

    public static void main(String[] args) throws ParseException {
        Date d = new Date();    //创建日期对象

        SimpleDateFormat sdf = new SimpleDateFormat();  //空参默认是 18-1-4 下午11:44 这种格式
        //format方法，将Date格式化成一个字符串
        String dateString = sdf.format(d);
        System.out.println(dateString);

        System.out.println("------------------------");

        //构造函数传入参数为 格式化后的字符串
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //2018-01-04 23:48:24

        //format    将日期对象转换为字符串
        String res = s1.format(d);
        System.out.println(res);

        //parse     将时间字符串转换为日期对象   --> 这里需要捕捉一个异常
        String time = "2018-01-04 23:39:20";
        try {
            Date day = s1.parse(time);
            System.out.println(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------");

        //小例子 ： 计算自己来到这个世界多少天
        days();


    }

    private static void days() throws ParseException {
        SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = "1989-12-19";
        Date today = new Date();
        Date birthdayDate = dd.parse(birthday);
        long days = today.getTime() - birthdayDate.getTime();
        long l = days / (3600 * 24 * 1000);
        System.out.println("我来到这个世界已经 " + l + " 天了！");
    }
}
