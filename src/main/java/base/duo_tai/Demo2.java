package base.duo_tai;

/**
 * Created by wanglei on 2018/1/25.
 */
public class Demo2 {
    public static void main(String[] args) {
//        new Apple().print();
//        new Orange().print();

        Mechine m = new Mechine();
        m.sequence(new Apple());
        m.sequence(new Orange());
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

class Mechine {
    public void sequence(Fruit f) {
        f.print();

    }
}
