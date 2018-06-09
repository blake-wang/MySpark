package base.注解.自定义注解;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
//    String desc( int a);  //注解的成员不能有参数
//    String desc() throws Exception; //注解的成员不能抛异常
    //当注解只有一个成员的时候，要起名为value，这是一个约定俗称的规则
    //如果注解，一个成员都没有，那这个注解就是一个标识注解
    String value();

}
