package base.stringDemo;

/**
 * Created by wanglei on 2018/1/3.
 * String 常用API
 * <p>
 * ""和null的区别
 * ""是字符串常量，同时也是一个String类的对象，既然是对象当然可以调用String类中的方法
 * null是空常量，不能调用任何的方法，否则会出现空指针异常，null常量可以给任意的引用数据类型赋值
 * <p>
 * 根据索引去取字符串的时候，可能会出现字符串索引角标越界异常StringIndexOutOfBoundsException
 */
public class stringAPIDemo {
    public static void main(String[] args) {
        String s1 = "wanglei";
        String s2 = "wanglei";
        String s3 = "Wanglei";
        String s4 = "wo men Zai guang dong,Guang zhou!";
        String s5 = "";
        String s6 = null;
        String s7 = "  王磊  ， 你好!";

        //equals  比较字符串的内容是否相同，区分大小写
//        equals(s1, s2, s3);

        //equalsIgnoreCase  比较字符串的内容是否相同，不区分大小写
//        equalsIgnoreCase(s1, s2, s3);

        //contains  判断大字符串是否包含小字符串,区分大小写
//        contains(s4);

        //startsWith    判断字符串是否以某个指定的字符串开头,区分大小写
//        startsWith(s4);

        //endsWith  判断字符串是否以某个指定的字符串结尾
//        endsWith(s4);

        //isEmpty   判断字符串是否为空，即""
//        isEmpty(s4, s5, s6);

        //indexOf  返回字符，或者字符串第一次出现处的索引
//        indexOf1(s4);

        //indexOf(int ch,int fromIndex)  返回指定字符在此字符串中从指定位置后第一次出现处的索引
//        indexOf2(s4);

        //charAt    获取指定索引位置的字符
//        charAt(s4);

        //lastIndexOf   获取元素最后一次出现的索引
//        lastIndexOf(s4);

        //substring     获取子字符串
//        substring(s4);

        //trim  去掉字符串两端的空格
//        trim(s7);

        //toUpperCase toLowerCase   将字符串中的字符，全部转换成大写，或者全部转换成小写,返回的是一个新的字符串
//        toUpperLowerCase(s4);

        //toCharArray   将字符串转换成字符数组
//        toCharArray(s4);

        //getBytes()    将字符串转换为字节数组 , 这个也叫编码：把我们人看得懂的转换为计算机看得懂的
//        getBytes(s4);

        //valueOf   可以将任意数据类型，转换成字符串
//        valueOf();

        //concat    拼接字符串
//        concat(s4, s7);

        //replace   替换字符串中的字符，生成新的字符串
//        replace(s4);

        //compareTo 按照码表值比较两个字符串的大小，大于是正数，小于是负数，等于是0
//        compareTo();

        //compareToIgnoreCase   按照码表比较字符串的大小，忽略大小写
//        compareToIgnoreCase();

        testHashCode();


    }

    private static void testHashCode() {
        //不同字符串的hashCode不同
        String s8 = "wanglei";
        String s9 = "aixu";
        System.out.println(s8.hashCode());
        System.out.println(s9.hashCode());
    }

    private static void compareToIgnoreCase() {
        String ss1 = "wanglei";
        String ss2 = "WANGLEI";
        int i = ss1.compareToIgnoreCase(ss2);
        System.out.println(i);
        System.out.println(ss1.compareTo(ss2));
    }

    private static void compareTo() {
        String ss1 = "bbc";
        String ss2 = "abc";
        int i = ss1.compareTo(ss2);
        System.out.println(i);
    }

    private static void replace(String s4) {
        System.out.println(s4);
        System.out.println(s4.replace("g", "p"));
        System.out.println(s4.replace("x", "p"));    //x不存在，保留原字符不改变
        System.out.println(s4.replace(" ", "HAHA"));
    }

    private static void concat(String s4, String s7) {
        System.out.println(s4.concat(s7));
        System.out.println(s7.concat(s4));
    }

    private static void valueOf() {
        System.out.println(String.valueOf(123));
        System.out.println(String.valueOf(true));
        long l = 999999999999999999L;
        System.out.println(String.valueOf(l));
        System.out.println(String.valueOf(12.01));
        float f01 = 12.2f;
        float f02 = 12.27f;
        Double d01 = 19.6;
        Double d02 = 19.69;
        System.out.println(String.valueOf(f01));
        System.out.println(String.valueOf(f02));
        System.out.println(String.valueOf(d01));
        System.out.println(String.valueOf(d02));
        String s = f01 + "";
        System.out.println(s);
    }

    private static void getBytes(String s4) {
        byte[] bytes = s4.getBytes();
        for (byte aByte : bytes) {
            System.out.print(aByte + " ");
        }
        System.out.println(bytes);
    }

    private static void toCharArray(String s4) {
        char[] chars = s4.toCharArray();
        System.out.println(chars[8]);
    }

    private static void toUpperLowerCase(String s4) {
        System.out.println(s4);
        System.out.println(s4.toLowerCase());
        System.out.println(s4.toUpperCase());
    }

    private static void trim(String s7) {
        System.out.println(s7);
        System.out.println(s7.trim());
    }

    private static void substring(String s4) {
        System.out.println(s4.length());
        System.out.println(s4.substring(4, 16)); //包含头不包含尾，返回角标4-15的元素
        System.out.println(s4.substring(4));    //返回从角标4开始到结尾的全部元素
//        System.out.println(s4.substring(44)); //如果取值范围超出字符串的长度，会报StringIndexOutOfBoundsException
//        System.out.println(s4.substring(4,44));
    }

    private static void lastIndexOf(String s4) {
        System.out.println(s4.length());
        System.out.println(s4.indexOf("o")); //第一次出现o的索引
        System.out.println(s4.lastIndexOf("o"));    //最后一次出现o的索引
    }

    private static void charAt(String s4) {
        char c = s4.charAt(9);
        System.out.println(c);//返回索引8位置的字符
    }

    private static void indexOf2(String s4) {
        System.out.println(s4.length());
        System.out.println(s4.indexOf("g"));
        System.out.println(s4.indexOf("g", 5)); //从索引5开始向后查找，如果存在，就返回第一次出现的索引，如果不存在，返回-1
        System.out.println(s4.indexOf("g", 29));
    }

    private static void indexOf1(String s4) {
        System.out.println(s4.length());
        System.out.println(s4.indexOf("g"));
        System.out.println(s4.indexOf("p"));    //如果不存在，会返回-1
        System.out.println(s4.indexOf("do"));   //把"do"当成一个字符來计算位置
        System.out.println(s4.indexOf(" zh"));  //把" zh"当成一个字符來计算位置
        System.out.println(s4.indexOf("shen")); //如果不存在，会返回-1
    }

    private static void isEmpty(String s4, String s5, String s6) {
        System.out.println(s4.isEmpty());
        System.out.println(s5.isEmpty());
        System.out.println(s6 == null);
    }

    private static void endsWith(String s4) {
        System.out.println(s4.endsWith("zhou"));
        System.out.println(s4.endsWith("!"));
        System.out.println(s4.endsWith(" zhou!"));
    }

    private static void startsWith(String s4) {
        System.out.println(s4.startsWith("wo"));
        System.out.println(s4.startsWith("W"));
        System.out.println(s4.startsWith("wo "));
        System.out.println(s4.startsWith("men"));
        System.out.println(s4.startsWith("wo men zai"));
    }

    private static void contains(String s4) {
        System.out.println(s4.contains("guang"));
        System.out.println(s4.contains("Guang"));
        System.out.println(s4.contains("shenzhen"));
    }

    private static void equalsIgnoreCase(String s1, String s2, String s3) {
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.equalsIgnoreCase(s3));
    }

    private static void equals(String s1, String s2, String s3) {
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}
