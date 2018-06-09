package base.exceptionDemo;

/**
 * Created by wanglei on 2018/1/15.
 * 自定义异常
 * <p>
 * 为什么要有自定义异常：
 * 通过名字区分到底是神马异常，有针对的解决办法
 * 自定义异常的概述
 * 继承自Exception
 * 继承自RuntimeException
 */
public class exceptionDemo2 {

    public static void main(String[] args) {
        Student stu = new Student();
        try {
            stu.setAge(190);
        } catch (AgeException e) {
            e.printStackTrace();
        }
    }


}

class Student {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            throw new AgeException("年龄异常！");
        }
    }
}

class AgeException extends Exception {

    public AgeException(String s) {
        super(s); //调用父类的方法
    }
}


