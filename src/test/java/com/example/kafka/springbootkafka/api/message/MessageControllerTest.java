package com.example.kafka.springbootkafka.api.message;

import com.example.kafka.springbootkafka.api.MessageController;
import com.example.kafka.springbootkafka.services.MessageProducer;
import com.example.kafka.springbootkafka.util.MessageUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link MessageController}.
 */
@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @InjectMocks
    private MessageController messageController;

    @Mock
    private MessageProducer messageProducer;

    @Test
    void producerMessageAsync(){
        // act and assert
        ResponseEntity<Void> responseEntity = messageController.producerMessageAsync(MessageUtil.createValidMessage());
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void producerMessageSync(){
        // act and assert
        ResponseEntity<Void> responseEntity = messageController.producerMessageSync(MessageUtil.createValidMessage());
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
