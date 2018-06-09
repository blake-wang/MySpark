package udf;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.spark.sql.api.java.UDF1;

/**
 * Created by bigdata on 18-1-25.
 */
public class TestMd5 implements UDF1<Object, String> {
    @Override
    public String call(Object s) throws Exception {
        String s2 = String.valueOf(s);
        String s1 = DigestUtils.md5Hex(s2);
        return s1;
    }
}
