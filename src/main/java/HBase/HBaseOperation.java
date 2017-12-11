package HBase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import scala.math.Ordering;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigdata on 17-12-10.
 * CRUD HBase
 */
public class HBaseOperation {
    static Configuration conf = null;

    static {
        conf = HBaseConfiguration.create();
        try {
            HTable table = new HTable(conf, Bytes.toBytes("user"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        put();
//        putList();
//        getByRowKey();
//        get();
        delete();
    }

    //按指定列删除
    private static void delete() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        HTable table = new HTable(conf, "user");
        Delete delete = new Delete(Bytes.toBytes("10001"));
        delete.deleteColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
        table.delete(delete);
        table.close();
    }

    //按指定列查询
    private static void get() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        HTable table = new HTable(conf, "user");
        Get get = new Get(Bytes.toBytes("104"));
        get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
        Result result = table.get(get);
        byte[] value = result.getValue(Bytes.toBytes("info"), Bytes.toBytes("name"));
        System.out.println(new String(value));
        table.close();
    }

    //根据rowKey查询多条数据
    private static void getByRowKey() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        HTable table = new HTable(conf, "user");
        Get get = new Get(Bytes.toBytes("104"));
        Result result = table.get(get);
        for (KeyValue kv : result.raw()) {
            System.out.println(Bytes.toString(kv.getFamily()));
            System.out.println(Bytes.toString(kv.getQualifier()));
            System.out.println(Bytes.toString(kv.getValue()));
            System.out.println(kv.getTimestamp());
        }
        table.close();
    }

    //插入多条数据
    private static void putList() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        HTable table = new HTable(conf, Bytes.toBytes("user"));
        Put put = new Put(Bytes.toBytes("104"));
        List<Put> list = new ArrayList<>();
        put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("aixu"));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("26"));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("phone"), Bytes.toBytes("18216821991"));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("sex"), Bytes.toBytes("female"));
        list.add(put);
        table.put(list);
        table.close();
    }


    //插入一条数据
    private static void put() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        HTable table = new HTable(conf, Bytes.toBytes("user"));
        Put put = new Put(Bytes.toBytes("10001"));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("wanglei"));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("22"));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("phone"), Bytes.toBytes("15814053390"));
        table.put(put);
        table.close();
    }
}
