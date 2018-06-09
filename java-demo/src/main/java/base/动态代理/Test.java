package base.动态代理;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        //动态代理 1：
//        UserImp userImp = new UserImp();
//        userImp.add();
//        userImp.delete();
//
//        System.out.println("----------------------------------------");
//
//        MyInvocationHandler m = new MyInvocationHandler(userImp);
//        User u = (User) Proxy.newProxyInstance(userImp.getClass().getClassLoader(), userImp.getClass().getInterfaces(), m);
//        u.add();
//        u.delete();




        //动态代理2：
        StudentImp si = new StudentImp();
        si.login();
        si.submit();

        System.out.println("--------------------------------------");

        MyInvocationHandler mi = new MyInvocationHandler(si);
        Student student = (Student) Proxy.newProxyInstance(si.getClass().getClassLoader(), si.getClass().getInterfaces(), mi);
        student.login();
        student.submit();



    }
}
