package Test;



/**
 * Created by JSJSB-0071 on 2017/7/21.
 * java.sql.Date是java.util.Date的子类
 */
public class SqlDateTime {
    public static void main(String[] args) {

        //get the standard date and time
        java.util.Date javaDate = new java.util.Date();
        long javaTime = javaDate.getTime();
        System.out.println("javaDate : "+javaDate.toString());
        System.out.println("javaTime : "+javaTime);


        //get and display sql date
        java.sql.Date sqlDate = new java.sql.Date(javaTime);
        System.out.println("sqlDate : "+sqlDate.toString());


        //get and display sql time
        java.sql.Time sqlTime = new java.sql.Time(javaTime);
        System.out.println("sqlTime : "+sqlTime);

        //get and display sql timestamp
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
        System.out.println("sqlTimestamp : "+sqlTimestamp);


    }
}
