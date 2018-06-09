package base.设计模式;

/**
 * Created by wanglei on 2018/1/17.
 *
 * 装饰设计模式
 * 好处：耦合性不强，被装饰的类的变化与装饰类的变化无关
 *
 *
 */
public class ZhuangShi {

    public static void main(String[] args) {
        Student s = new Student();
        s.code();

        System.out.println("--------------");

        HeiMaStudent hms = new HeiMaStudent(new Student());
        hms.code();
    }
}

interface Coder {
    public void code(); //抽象方法没有方法体
}

class Student implements Coder{

    @Override
    public void code() {
        System.out.println("java");
        System.out.println("linux");
    }
}

class HeiMaStudent implements Coder{
    //1、获取被装饰类的引用
    private Student s ;

    //2、在构造方法中传入被装饰类的对象
    public HeiMaStudent (Student s ){
        this.s = s;
    }

    //3、对原有的功能进行升级
    @Override
    public void code() {
        s.code();
        System.out.println("scala");
        System.out.println("python");
        System.out.println("mysql");
    }
}
