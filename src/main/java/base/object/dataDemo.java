package base.object;

import java.util.Date;
import java.util.List;

/**
 * Created by wanglei on 2018/1/4.
 * java的数据类型：基本数据类型，引用数据类型
 */
public class dataDemo {
    public static void main(String[] args) {
        //基本数据类型(四类八种：整数型，浮点型，布尔型，字符型)
        //short从-32768到32767
        //int从-2147483648,到2147483647共10位
        //long从-9223372036854775808到9223372036854775807共19位

        //byte类型占1个字节
        //short类型占2个字节
        //int类型占4个字节
        //long类型占8个字节
        //float类型占4个字节
        //doouble类型占8个字节
        //char类型占2个字节
        byte b = 10;
        short s = 100;
        int i = 1000000;
        long l = 1000000000L;   //声明long类型，一般在后面加l或者L，建议加L，看的清楚
        float f = 12.3F;    //如果要声明一个float类型，必须在后面加f或者F
        double d = 12.35;
        boolean boo = true;
        char c = 'C';


        //引用数据类型(类，接口，数组)
        //类
        Date date = new Date();
        String str = new String();
        //接口
        List list;
        //数组
        String[] arr = new String[8];


    }
}
