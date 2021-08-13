package com.example.kafka.springbootkafka.configs;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import com.example.kafka.springbootkafka.helpers.KafkaConstants;

@Configuration
public class TopicConfig {

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.AZURE_EVENT_HUB);
        configs.put("security.protocol", KafkaConstants.SASL_SSL);
        configs.put("sasl.mechanism", KafkaConstants.PLAIN);
        configs.put("sasl.jaas.config", KafkaConstants.SASL_JAAS_CONFIG_MESSAGE);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topicMessage() {
        return TopicBuilder.name(
            KafkaConstants.TOPIC_MESSAGE
        )
            .partitions(1)
            .replicas(1)
            .build();
    }
}