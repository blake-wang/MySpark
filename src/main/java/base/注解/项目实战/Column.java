package base.注解.项目实战;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) //FIELD：表明注解的作用域是字段上
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String value();
}
