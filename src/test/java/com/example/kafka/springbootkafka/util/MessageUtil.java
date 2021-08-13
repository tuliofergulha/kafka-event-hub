package com.example.kafka.springbootkafka.util;

import com.example.kafka.springbootkafka.model.Message;

/**
 * Message utility class used in tests.
 */
public final class MessageUtil {

    private MessageUtil() {}

    public static Message createValidMessage(){
        Message message = new Message();
        message.setId(1L);
        message.setEmail("teste@teste.com");
        message.setValue("Enviando mensagem");
        return message;
    }
}
