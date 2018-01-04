package base.object;

import java.util.Random;

/**
 * Created by wanglei on 2018/1/4.
 * Random类
 *
 * 生成随机数
 */
public class RandomDemo {
    public static void main(String[] args) {

        //空参构造
        Random random = new Random();
        //生成一个在int取值范围之内的随机数
        int i = random.nextInt();
        System.out.println(i);
        //如果nextInt方法参数传入100，则取值范围为 0 ~ 100 ，包含0，不包含100
        int i100 = random.nextInt(100);
        System.out.println(i100);

        System.out.println("======================");

        //有参构造    第二个参数传入的是一个种子，每次用nextInt会计算出一个固定的值
        Random random2 = new Random(100);

        int i1 = random2.nextInt();
        int i2 = random2.nextInt();
        System.out.println(i1);
        System.out.println(i2);


    }
}
