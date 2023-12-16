package com.atguigu.kafaka.controller;

import com.atguigu.kafaka.config.KafkaCommonProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Properties;

public class KafkaConsumerTest {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerTest.class);

    public static KafkaConsumer<String, String> getDefaultKafkaConsumer(KafkaCommonProperties kafkaCommonProperties) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaCommonProperties.getKafkaHost());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaCommonProperties.getGroupId());
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, kafkaCommonProperties.getAutoCommit());
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, kafkaCommonProperties.getAutoCommitIntervalMs());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaCommonProperties.getAutoOffsetReset());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaCommonProperties.getKeyDecoder());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaCommonProperties.getValueDecoder());
        return new KafkaConsumer<>(properties);
    }

    public static void main(String[] args) {
        try {
            KafkaCommonProperties kafkaCommonProperties = new KafkaCommonProperties();
            KafkaConsumer<String, String> consumer = getDefaultKafkaConsumer(kafkaCommonProperties);
            consumer.subscribe(kafkaCommonProperties.getTopic());
            while (Boolean.TRUE) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    logger.info(">>>>>>>>Consumer offset:{}, value:{}", record.offset(), record.value());
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
