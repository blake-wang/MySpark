package base.stringDemo;

/**
 * Created by wanglei on 2017/12/17.
 * String类
 * <p>
 * <p>
 * String str = "abc";
 * a:字符串字面值"abc"也可以看成是一个字符串对象
 * b:字符串是常量，一旦被赋值，就不能被改变
 * <p>
 * public String():空构造
 * public String(byte[] bytes):把字节数组转换成字符串
 * public String(byte[] bytes,int index,int length):把字节数组的一部分转换成字符串
 * public String(char[] value):把字符数组转换成字符串
 * public String(char[] value,int index,int count):把字符数组的一部分转换成字符串
 * public String(String original):把字符串常量值转换成字符串
 */
public class createStringDemo {
    public static void main(String[] args) {
        //chaochang();
        //demo1();

        //通过各种构造函数创建字符串
        //createString();


    }

    private static void createString() {

        //空构造
        String s1 = new String();
        System.out.println(s1);

        //字节数组
        byte[] arr1 = {97, 98, 99};
        String s2 = new String(arr1);//解码，将计算机读的懂的转换成我们读得懂的
        System.out.println(s2);
        byte[] arr2 = {97, 98, 99, 100, 101, 102};
        String s3 = new String(arr2, 3, 2);
        System.out.println(s3);

        //字符数组
        char[] arr3 = {'x', 'y', 'z', 'o', 'p', 'q'};//字符，只能放在单引号中，放在双引号中就是字符串了
        String s4 = new String(arr3);
        System.out.println(s4);
        String s5 = new String(arr3, 2, 3);
        System.out.println(s5);

        //传入字符串
        String s6 = new String("zhongguo");
        System.out.println(s6);
    }

    private static void demo1() {
        String str = "abc";//"abc"可以看成一个字符串对象
        System.out.println(str);//String类重写了toString方法，返回的是该对象本身
    }

    private static void chaochang() {
        String str = "0";
        //截取长度超过字符串的长度，会报错
        String substring = str.substring(0, 10);
        System.out.println(substring);
    }
}
