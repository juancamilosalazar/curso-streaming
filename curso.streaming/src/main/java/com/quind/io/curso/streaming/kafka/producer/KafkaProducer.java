package com.quind.io.curso.streaming.kafka.producer;


import com.quind.io.curso.streaming.model.RecomendationResponse;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    private final KafkaTemplate<String,RecomendationResponse> kafkaTemplate;

    private final String TOPIC_NAME = "recomendation-response-topic";
    public KafkaProducer(KafkaTemplate<String, RecomendationResponse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage (RecomendationResponse recomendationResponse){
        kafkaTemplate.send(TOPIC_NAME,recomendationResponse);
        System.out.println("EL mensaje fué enviado: " + recomendationResponse.getRecomendationList());
    }


}
