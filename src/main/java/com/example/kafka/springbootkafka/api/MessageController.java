package com.example.kafka.springbootkafka.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.springbootkafka.model.Message;
import com.example.kafka.springbootkafka.services.MessageProducer;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageProducer producer;

    @Autowired
    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/producer-async")
    public ResponseEntity<Void> producerMessageAsync(@RequestBody Message message) {
        this.producer.sendAsync(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/producer-sync")
    public ResponseEntity<Void> producerMessageSync(@RequestBody Message message) {
        this.producer.sendSync(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
