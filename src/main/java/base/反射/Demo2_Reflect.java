package base.反射;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/25.
 * 通过反射读取配置文件，创建对象
 */
public class Demo2_Reflect {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        //读取配置文件
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/object.properties"));
        //获取要创建的对象的类名
        String objectName = br.readLine();
        //获取该类的字节码对象
        Class clazz = Class.forName(objectName);
        //通过clazz对象创建该类的对象
        Object obj = clazz.newInstance();

        Machine m = new Machine();
        m.sequence((Fruit) obj);


    }
}

interface Fruit {
    public void print();
}

class Apple implements Fruit {

    public void print() {
        System.out.println("一杯苹果汁");
    }
}

class Orange implements Fruit {
    public void print() {
        System.out.println("一杯橙汁");
    }
}

class Machine {
    public void sequence(Fruit f) {
        f.print();

    }
}
