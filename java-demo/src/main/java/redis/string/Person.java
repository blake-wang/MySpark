package redis.string;

import java.io.Serializable;

/**
 * Created by wanglei on 2017/5/18.
 */
public class Person implements Serializable{
    private String name;
    private int    age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + ",age=" + age;
    }
}
