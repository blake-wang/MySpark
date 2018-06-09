package base.demo;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bigdata on 18-1-16.
 */
public class demo1 {
    public static void main(String[] args) {

        SimpleDateFormat sif = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            FileOutputStream fos = new FileOutputStream("/home/hduser/projs/data_wl/xxx.txt");
            int i = 0;
            while (i < Integer.valueOf(args[0])) {
                String format = sif.format(new Date());
                fos.write(("现在的时间是 ： " + format).getBytes());
                fos.write("\r\n".getBytes());
                Thread.sleep(1000);
                i++;
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
