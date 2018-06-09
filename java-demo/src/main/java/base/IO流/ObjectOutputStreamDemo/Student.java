package base.IO流.ObjectOutputStreamDemo;

import java.io.Serializable;

/**
 * Created by wanglei on 2018/1/18.
 * <p>
 * serialVersionUID    序列化id号
 * <p>
 * 序列化的对象 ，最好加一个序列化id号
 */
class Student implements Serializable {

    //序列化id号
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
