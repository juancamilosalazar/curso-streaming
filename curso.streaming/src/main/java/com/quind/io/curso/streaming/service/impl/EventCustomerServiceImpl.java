package com.quind.io.curso.streaming.service.impl;

import com.quind.io.curso.streaming.apivertex.ApiVertexInterface;
import com.quind.io.curso.streaming.kafka.producer.KafkaProducer;
import com.quind.io.curso.streaming.model.EventCustomer;
import com.quind.io.curso.streaming.model.RecomendationResponse;
import com.quind.io.curso.streaming.service.EventCustomerServiceInterface;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class EventCustomerServiceImpl implements EventCustomerServiceInterface {

    private ApiVertexInterface apiVertexInterface;
    private KafkaProducer kafkaProducer;


    public EventCustomerServiceImpl(ApiVertexInterface apiVertexInterface, KafkaProducer kafkaProducer) {
        this.apiVertexInterface = apiVertexInterface;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void consumeRecomendationEngine(EventCustomer eventCustomer) {
        try {
            RecomendationResponse recomendationResponse = new RecomendationResponse();
            recomendationResponse.setCustomer(eventCustomer.getCustomer());
            recomendationResponse.setRecomendationList(apiVertexInterface.consumeModelIa(eventCustomer));
            kafkaProducer.sendMessage(recomendationResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
