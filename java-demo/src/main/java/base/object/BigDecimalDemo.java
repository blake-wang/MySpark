package base.object;

import java.math.BigDecimal;

/**
 * Created by wanglei on 2018/1/4.
 * BigDecimal类
 * <p>
 * 为了更精确的存储小数
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        //2.0-1.1 计算结果为0.8999999999999999 ，在计算机中表示的不精确
        System.out.println(2.0 - 1.1);


        //构造函数传入double类型，用bd.substract计算，结果能更精确一点，但是还是不够精确
        BigDecimal bd1 = new BigDecimal(2.0);
        BigDecimal bd2 = new BigDecimal(1.1);
        System.out.println(bd1.subtract(bd2));


        //构造类型传入String类型，用bd.substract计算，结果是精确的  -->  开发时使用这种方式
        BigDecimal bd3 = new BigDecimal("2.0");
        BigDecimal bd4 = new BigDecimal("1.1");
        System.out.println(bd3.subtract(bd4));
        System.out.println(bd3.add(bd4));
        System.out.println(bd3.multiply(bd4));
//        System.out.println(bd3.divide(bd4));  //这一句会报错，因为除不尽

        //valueOf方法也可以实现小数精确计算 --> 开发时也使用这种方式
        BigDecimal bd5 = BigDecimal.valueOf(2.0);
        BigDecimal bd6 = BigDecimal.valueOf(1.1);
        System.out.println(bd5.subtract(bd6));


    }
}
