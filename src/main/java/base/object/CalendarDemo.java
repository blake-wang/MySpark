package base.object;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wanglei on 2018/1/5.
 * Calendar类  日历类
 * <p>
 * 成员方法
 * get()
 * set()
 */
public class CalendarDemo {
    public static void main(String[] args) {
        //Calendar基本用法
//        baseUse();

        //set and get
//        setAndget();

        //setTime and getTime
        setTimeAndgetTime();




    }

    /**
     * 通过setTime和getTime来计算不同的天数以及不同的小时
     */
    private static void setTimeAndgetTime() {
        Calendar c = Calendar.getInstance();
        Date d = new Date();
        c.setTime(d);
        c.add(Calendar.DATE,-10);
        Date time = c.getTime();
        System.out.println(time);

        SimpleDateFormat sip = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sip.format(time);
        System.out.println(format);

        System.out.println("====================================");

        Calendar c2 = Calendar.getInstance();
        Date now = c2.getTime();
        System.out.println("now : " + now);

        Date d2 = new Date();
        System.out.println("d2 : " +d2);
        c2.setTime(d2);
        System.out.println(c2);


    }

    private static void setAndget() {
        Calendar cc = Calendar.getInstance();
        System.out.println(cc.get(Calendar.YEAR) + "年"
                + getNum(cc.get(Calendar.MONTH) + 1) + "月"
                + getNum(cc.get(Calendar.DAY_OF_MONTH)) + "日"
                + getWeek(cc.get(Calendar.DAY_OF_WEEK)));

        //add()   对指定的字段进行，向前件，向后加 计算日期
        cc.add(Calendar.YEAR, 1);
        cc.add(Calendar.MONTH, 0);
        cc.add(Calendar.DAY_OF_MONTH, 5);
        System.out.println(cc.get(Calendar.YEAR) + "年"
                + getNum(cc.get(Calendar.MONTH) + 1) + "月"
                + getNum(cc.get(Calendar.DAY_OF_MONTH)) + "日"
                + getWeek(cc.get(Calendar.DAY_OF_WEEK)));

        //set()   根据指定字段，设置年，月，日
        cc.set(Calendar.YEAR, 2000);

        System.out.println(cc.get(Calendar.YEAR) + "年"
                + getNum(cc.get(Calendar.MONTH) + 1) + "月"
                + getNum(cc.get(Calendar.DAY_OF_MONTH)) + "日"
                + getWeek(cc.get(Calendar.DAY_OF_WEEK)));

        cc.set(2017, 11, 19);
        System.out.println(cc.get(Calendar.YEAR) + "年"
                + getNum(cc.get(Calendar.MONTH) + 1) + "月"
                + getNum(cc.get(Calendar.DAY_OF_MONTH)) + "日"
                + getWeek(cc.get(Calendar.DAY_OF_WEEK)));
    }

    private static void baseUse() {
        Calendar c = Calendar.getInstance();    //父类引用指向子类对象
        
        int year = c.get(Calendar.YEAR);
        System.out.println("year : "+year);

        int month = c.get(Calendar.MONTH);
        System.out.println("month : "+month);

        int day = c.get(Calendar.DATE);
        System.out.println("day : "+day);

        int hour = c.get(Calendar.HOUR);
        System.out.println("hour : "+hour);

        int minute = c.get(Calendar.MINUTE);
        System.out.println("minute : "+minute);

        int second = c.get(Calendar.SECOND);
        System.out.println("second : "+second);




        System.out.println(c.get(Calendar.YEAR));           //通过字段获取年
        System.out.println(c.get(Calendar.MONTH));          //通过字段获取月，月是从0开始，0-11
        System.out.println(c.get(Calendar.DAY_OF_MONTH));   //在当月的天数
        System.out.println(c.get(Calendar.DAY_OF_YEAR));    //在当年的天数
        System.out.println(c.get(Calendar.DAY_OF_WEEK));    //星期天是第一天，星期六是最后一天
        System.out.println(c.get(Calendar.DATE));           //获取日期，与DAY_OF_MONTH 相同
        System.out.println(c.get(Calendar.HOUR));           //获取小时
        System.out.println(c.get(Calendar.MINUTE));         //获取分钟数

        System.out.println(c.get(Calendar.YEAR) + "年"
                + getNum(c.get(Calendar.MONTH) + 1) + "月"
                + getNum(c.get(Calendar.DAY_OF_MONTH)) + "日"
                + getWeek(c.get(Calendar.DAY_OF_WEEK)));

        System.out.println("--------------------------------------");
    }

    /**
     * 将星期存储表中进行查表
     * 1、返回值类型String
     * 2、参数列表int week
     *
     * @param week
     * @return
     */
    public static String getWeek(int week) {
        String[] arr = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return arr[week];
    }

    /**
     * 如果是个数数字，前面补0
     *
     * @param num
     * @return
     */
    public static String getNum(int num) {
//        if (num >= 10) {
//            return "" + num;
//        } else {
//            return "0" + num;
//        }

        return num >= 10 ? "" + num : "0" + num;    //三元运算符
    }
}
