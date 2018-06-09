package redis.string;

import com.google.gson.Gson;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import redis.clients.jedis.Jedis;

/**
 * Created by wanglei on 2017/5/18.
 * 使用场景： 保存对象  以及 计数器
 */
public class ProductService {
    @Test
    public void saveProduct2Redis()
            throws Exception
    {
        //初始化对象
        Person person = new Person("刘德华", 17);
        //将刘德华的信息保存到Redis中
        Jedis jedis = new Jedis("127.0.0.1", 6379);


        //第一种方式：直接保存对象
        //直接保存对象的toString方法，这种方法不反序列化对象
        jedis.set("user:liudehua:str", person.toString());
        System.out.println("user:liudehua:str    ：   " + jedis.get("user:liudehua:str"));


        //第二种方式:序列化对象后保存  ------------  一般都使用这种方式
        jedis.set("user:liudehua:obj".getBytes(), getBytesByProduct(person));
        byte[] productBytes = jedis.get("user:liudehua:obj".getBytes());
        Person pByte        = getProductByBytes(productBytes);
        System.out.println(pByte.getName() + "    " + pByte.getAge());

        //第三种方式：保存Json化之后的对象
        jedis.set("user.liudehua:json", new Gson().toJson(person));
        String personJson = jedis.get("user.liudehua:json");
        Person pJson      = new Gson().fromJson(personJson, Person.class);
        System.out.println(pJson.getName() + "   " + pJson.getAge());

    }


    //对象反序列化方法
    private Person getProductByBytes(byte[] productBytes)
            throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(productBytes);
        ObjectInputStream    objectInputStream    = new ObjectInputStream(byteArrayInputStream);
        return (Person) objectInputStream.readObject();
    }



    //对象序列化方法
    private byte[] getBytesByProduct(Person product) {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ba);
            oos.writeObject(product);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ba.toByteArray();
    }
}
