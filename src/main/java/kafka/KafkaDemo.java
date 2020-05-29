package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * Created by dell on 2020/5/28.
 */
public class KafkaDemo {
    private static String servers = "10.129.1.14:9092,10.129.1.15:9092,10.129.1.16:9092";
    private static final String name = "HotwordTopic";

    public static void main(String[] args) {

        final KafkaConsumer<String, String> consumer = new KafkaDemo().getConsumer(null);
        consumer.subscribe(Collections.singletonList(name));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000); // 阻塞时间为1秒
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record.key() + record.value() + record.topic() + record.partition());
                }
                consumer.commitSync(); // 同步提交
                // consumer.commitAsync(); // 异步提交


            }
        } finally {
            consumer.close();
            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run() {
                    System.out.println("消费者开始退出");
                    consumer.wakeup();

                }
            });
        }


    }

    public KafkaConsumer<String, String> getConsumer(Properties prop) {
        if (prop == null) {
            Properties properties = new Properties();
            properties.put("bootstrap.servers", servers);
            properties.put("group.id", "1");
            properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
            return consumer;
        }
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(prop);
        return consumer;
    }
}
