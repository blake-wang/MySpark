package base.注解.自定义注解;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 解析注解
 * 1、找到类上的注解
 * 2、找到方法上的注解
 */
public class ParseAnnotation {
    public static void main(String[] args) {

        try {
            //1、使用类加载器加载类
            Class c = Class.forName("base.注解.自定义注解.Child");
            //2、找到类上面的注解
            boolean isExist = c.isAnnotationPresent(Description.class);
            if (isExist) {
                //3、拿到注解实例
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.value());
            }
            //4、找到方法上的注解（方法一）
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if (isMExist) {
                    Description md = (Description) m.getAnnotation(Description.class);
                    System.out.println(md.value());
                }
            }
            //找到方法上的注解（方法二）
            for (Method m : ms) {
                Annotation[] annotations = m.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Description) {
                        Description dd = (Description) annotation;
                        System.out.println(dd.value());
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
