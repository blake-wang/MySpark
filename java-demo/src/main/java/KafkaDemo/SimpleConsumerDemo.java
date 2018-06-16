package KafkaDemo;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.*;

public class SimpleConsumerDemo {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("zookeeper.connect", "s1010:2181");
        props.put("group.id", "g1");
        props.put("zookeeper.session.timeout.ms", "500");
        props.put("zookeeper.sync.time.ms", "250");
        props.put("auto.commit.interval.ms", "1000");

        //创建消费者配置对象
        ConsumerConfig conf = new ConsumerConfig(props);
        //创建连接器
        ConsumerConnector conn = Consumer.createJavaConsumerConnector(conf);

        Map<String, Integer> topicCount = new HashMap<>();
        Map<String, List<KafkaStream<byte[], byte[]>>> map = conn.createMessageStreams(topicCount);
        List<KafkaStream<byte[], byte[]>> list = map.get("test3");

        for (KafkaStream<byte[], byte[]> s : list) {
            ConsumerIterator<byte[], byte[]> iterator = s.iterator();
            while (iterator.hasNext()) {
                String msg = new String(iterator.next().message());
                System.out.println(msg);
            }
        }

    }
}
