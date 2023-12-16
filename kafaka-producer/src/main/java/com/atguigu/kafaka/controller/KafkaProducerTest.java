package com.atguigu.kafaka.controller;

import com.atguigu.kafaka.config.KafkaCommonProperties;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Properties;

public class KafkaProducerTest{
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerTest.class);

    public static KafkaProducer<String, String> getDefaultKafkaProducer(KafkaCommonProperties kafkaCommonProperties) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaCommonProperties.getKafkaHost());
        properties.put(ProducerConfig.ACKS_CONFIG, kafkaCommonProperties.getAck());
        properties.put(ProducerConfig.RETRIES_CONFIG, kafkaCommonProperties.getRetryTimes());
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaCommonProperties.getBatchSize());
        properties.put(ProducerConfig.LINGER_MS_CONFIG, kafkaCommonProperties.getLingerMs());
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaCommonProperties.getBufferMemory());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaCommonProperties.getKeyEncoder());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaCommonProperties.getValueEncoder());
        return new KafkaProducer<>(properties);
    }

    static class MyProducerCallback implements Callback {

        @Override
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            if (Objects.nonNull(exception)) {
                logger.error(">>>>>>>>>>Producer生产消息异常：", exception);
            }
            if (Objects.nonNull(metadata)) {
                logger.info(">>>>>>>>>>Producer生产消息：metadata：{}，partition:{}, offset：{}", metadata, metadata.partition(), metadata.offset());
            }
        }
    }

    public static void main(String[] args) {
        KafkaCommonProperties kafkaCommonProperties = new KafkaCommonProperties();
        KafkaProducer<String, String> producer = getDefaultKafkaProducer(kafkaCommonProperties);
        String message = "hello world ";
        try {
            for (int i = 0; i < 10; i++) {
                // 异步写入数据
                String topic = kafkaCommonProperties.getTopic().toArray()[0].toString();
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, message + i);
                producer.send(producerRecord, new MyProducerCallback());
            }
        } catch (Exception ex) {
            logger.error(">>>>>>>>生产数据异常：", ex);
            throw new RuntimeException(ex);
        } finally {
            producer.close();
        }
    }

}
