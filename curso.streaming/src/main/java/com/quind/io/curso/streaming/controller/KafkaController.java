package com.quind.io.curso.streaming.controller;

import com.quind.io.curso.streaming.kafka.producer.KafkaProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("send/kafka")
    public void sendMessage(@RequestBody String message){
       // kafkaProducer.sendMessage(message);
    }
}
