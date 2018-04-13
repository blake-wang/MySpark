package redis.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanglei on 2017/5/19.
 */
public class DateUtil {
    private static SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getDate(String dString)
            throws ParseException
    {
        return sSimpleDateFormat.parse(dString);
    }

    public static String getString(Date date) {
        return sSimpleDateFormat.format(date);
    }
}
