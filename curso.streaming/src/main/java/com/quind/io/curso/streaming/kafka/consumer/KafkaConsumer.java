package com.quind.io.curso.streaming.kafka.consumer;

import com.quind.io.curso.streaming.model.EventCustomer;
import com.quind.io.curso.streaming.service.EventCustomerServiceInterface;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private EventCustomerServiceInterface eventCustomerServiceInterface;

    public KafkaConsumer(EventCustomerServiceInterface eventCustomerServiceInterface) {
        this.eventCustomerServiceInterface = eventCustomerServiceInterface;
    }


    @KafkaListener(topics = "event-customer-topic", groupId = "event-customer", containerFactory = "eventCustomertListener")
    public void consumeMessage (EventCustomer eventCustomer){
       eventCustomerServiceInterface.consumeRecomendationEngine(eventCustomer);
    }

}
