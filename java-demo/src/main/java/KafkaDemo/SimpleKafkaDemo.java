package KafkaDemo;

import kafka.producer.KeyedMessage;
import kafka.producer.Producer;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class SimpleKafkaDemo {
    private static Producer<Integer, String> producer;
    private static final Properties props = new Properties();

    public static void main(String[] args) {
        //创建配置信息
        props.put("meta.broker.list", "s101:9092");
        props.put("serializer", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");
        producer = new Producer<Integer, String>(new ProducerConfig(props));
        KeyedMessage<Integer, String> msg = new KeyedMessage<Integer, String>("test3", "hello world");
//        producer.send(msg);
        System.out.println("over");

    }
}
