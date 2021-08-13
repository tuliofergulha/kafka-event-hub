package com.example.kafka.springbootkafka.api.message;

import com.example.kafka.springbootkafka.api.MessageController;
import com.example.kafka.springbootkafka.util.MessageUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Integration tests for {@link MessageController} producer sync message.
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageAsyncControllerIT {

    private static final String PATH = "/message/producer-async";

    @Autowired
    private TestRestTemplate testRestTemplate;

    private HttpEntity entity;

    @Test
    void producerMessageAsync(){
        // act
        ResponseEntity<Void> responseEntity = testRestTemplate.exchange(
                PATH,
                HttpMethod.POST,
                new HttpEntity<>(MessageUtil.createValidMessage()),
                Void.class
        );

        // assert
        assertThat(responseEntity).isNotNull();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void producerMessageAsync_NullRequest(){
        // act
        ResponseEntity<Void> responseEntity = testRestTemplate.exchange(
                PATH,
                HttpMethod.POST,
                new HttpEntity<>(null),
                Void.class
        );

        // assert
        assertThat(responseEntity).isNotNull();
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
