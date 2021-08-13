package com.example.kafka.springbootkafka.helpers;

public interface KafkaConstants {
    // Kafka Configs
    public static final String AZURE_EVENT_HUB = "ehub-name.servicebus.windows.net:9093";
    public static final String SASL_SSL = "SASL_SSL";
    public static final String PLAIN = "PLAIN";
    public static final String CLIENT_ID = "client1";

    // Kafka Consumer Configs
    public static final String GROUP_ID_CONFIG = "group-test";
    public static final String REQUEST_TIMEOUT_MS = "60000";

    // Kafka Topics "message" Config
    public static final String TOPIC_MESSAGE = "message";
    public static final String SASL_JAAS_CONFIG_MESSAGE = "USE_YOUR_CONFIG";

    // Kafka Topics "integrator-test" Config
    public static final String TOPIC_INTEGRATOR = "integrator_test";
    public static final String SASL_JAAS_CONFIG_INTEGRATOR = "USE_YOUR_CONFIG";
}
