package base.注解.项目实战;

import javafx.scene.control.Tab;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目说明：
 * 项目取自一个公司的持久层架构，用来代替Hibernate的解决方案，核心代码就是通过注解来实现的。
 * <p>
 * 需求：
 * 1、有一张用户表，字段包括用户ID，用户名，昵称，年龄，性别，所在城市，邮箱，手机号。
 * 2、方便的对每个字段或字段的组合条件进行检索，并打印出sql。
 * 3、使用方式要足够简单。
 * <p>
 * 解决思路：
 * 1、首先，考虑代码如何与数据库进行映射
 * 2、接下来，考虑query()方法的实现
 *
 * 总结与思考：
 * 1、第一个Filter关联的是user表，可以自由的定义查询条件，但是如果还有个department表，该怎么办？
 * 2、
 */
public class Test {
    public static void main(String[] args) {
        //查询user表
        Filter f1 = new Filter();
        f1.setId(10);//查询id为10的用户

        Filter f2 = new Filter();
        f2.setUserName("lucy");//查询用户名为lucy的用户
        f2.setAge(18);
        f2.setNickName("哎嘘");

        Filter f3 = new Filter();
        f3.setEmail("liu@sina.com,zh@163.com,77777@qq.com");//查询邮箱为其中任意一个的用户

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

        System.out.println("--------------------------------------------");

        //查询department表
        Filter2 ff1 = new Filter2();
        ff1.setLeader("王大锤");
        ff1.setAmount(99);
        ff1.setName("技术部");
        String ssql1 = query(ff1);
        System.out.println(ssql1);

    }

    //接收参数设为Object，就可以接收不同名称的表
    private static String query(Object f) {
        StringBuilder sb = new StringBuilder();
        //1、获取到class
        Class c = f.getClass();
        //2、获取到table的名字
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist) {
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");//这里传入1=1是为了保证，即使没有条件，sql语句也能执行
        //3、遍历所有的字段
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray) {
            //4、处理每个字段对应的sql
            //4.1、拿到字段名
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists) {
                //如果该字段没有注解，则跳过
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();//这个拿到的是注解里面的字符串
            //4.2、拿到字段的值
            String fieldName = field.getName();
            String getMethodName =
                    "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);//get方法的名称
            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);//通过反射获取方法
                fieldValue = getMethod.invoke(f, null);//通过反射调用get方法，inoke()第一个参数是调用的对象，第二个参数是方法的参数
            } catch (Exception e) {
                e.printStackTrace();
            }
            //4.3、拼装sql
            //判断字段值是否为null和0，如果是就跳过
            if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                continue;
            }
            sb.append(" and ").append(fieldName);
            //判断，如果查询条件是String，需要添加单引号
            if (fieldValue instanceof String) {
                //判断查询条件是否包含逗号，如果包含要按都好进行分割
                if (((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in(");
                    for (String v : values) {
                        sb.append("'").append(v).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(")");
                } else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            } else if (fieldValue instanceof Integer) {
                sb.append("=").append(fieldValue);
            }
        }
        return sb.toString();
    }
}
