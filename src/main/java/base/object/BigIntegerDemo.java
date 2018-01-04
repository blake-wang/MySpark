package base.object;

import java.math.BigInteger;

/**
 * Created by wanglei on 2018/1/4.
 * BigInteger类
 * <p>
 * 用来存储很大的数值
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
//        long l = 1000000000000000000000000L;
        String s = "1000000000000000000000000";

        //可以通过字符串创建很大的数
        BigInteger bi =new BigInteger(s);
        System.out.println(bi);

        BigInteger bi2 = new BigInteger("100");
        BigInteger bi3 = new BigInteger("3");

        //加
        System.out.println(bi2.add(bi3));

        //减
        System.out.println(bi2.subtract(bi3));

        //乘
        System.out.println(bi2.multiply(bi3));

        //除
        System.out.println(bi2.divide(bi3));



    }
}
