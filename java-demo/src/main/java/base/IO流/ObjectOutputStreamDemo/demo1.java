package base.IO流.ObjectOutputStreamDemo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 2018/1/18.
 * 对象操作流
 * ObjectOutputStream  ObjectInputStream
 * <p>
 * <p>
 * 注意：如果写入对象个数不知，取出对象的时候，容易出EOFException
 */
public class demo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        demo1();


        //创建多个对象
        Student s1 = new Student("wanglei", 29);
        Student s2 = new Student("aixu", 26);
        Student s3 = new Student("志超", 23);
        Student s4 = new Student("小康", 29);
        Student s5 = new Student("习大大", 60);

        //把多个对象装入一个集合中
        List list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\objectList.txt"));
//        oos.writeObject(list);//将整个集合一次性写出
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\objectList.txt"));
        ArrayList<Student> listR = (ArrayList) ois.readObject();//一次性读取整个集合
        for (Student s : listR) {
            System.out.println(s);
        }


    }

    private static void demo1() throws IOException, ClassNotFoundException {
        Student s = new Student("wanglei", 29);

        //对象输出流
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\object.txt"));
//        oos.writeObject(s);
//        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\object.txt"));
        Student sR = (Student) ois.readObject();
        System.out.println(sR);
    }
}

