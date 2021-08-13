package com.example.kafka.springbootkafka.configs;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.example.kafka.springbootkafka.helpers.KafkaConstants;
import com.example.kafka.springbootkafka.helpers.MessageDeserializer;
import com.example.kafka.springbootkafka.model.Message;

@Configuration
@EnableKafka
public class MessageConsumerConfig {

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Long, Message>>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Long, Message> factory =
            new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    @Bean
    public ConsumerFactory<Long, Message> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(),
            () -> new LongDeserializer(),
            () -> new MessageDeserializer());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.AZURE_EVENT_HUB);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID_CONFIG);
        props.put("security.protocol", KafkaConstants.SASL_SSL);
        props.put("sasl.mechanism", KafkaConstants.PLAIN);
        props.put("sasl.jaas.config", KafkaConstants.SASL_JAAS_CONFIG_MESSAGE);
        props.put("request.timeout.ms", KafkaConstants.REQUEST_TIMEOUT_MS);
        return props;
    }
}