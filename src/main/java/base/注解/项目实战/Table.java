package base.注解.项目实战;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE}) //TYPE：表明注解的作用域可以是类或者接口
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}
