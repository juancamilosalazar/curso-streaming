package com.quind.io.curso.streaming.kafka.config;

import com.quind.io.curso.streaming.model.EventCustomer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EventCustomerConsumerConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EventCustomer> eventCustomertListener(){
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(eventCustomerConsumer());
        return factory;
    }

    private ConsumerFactory<String, EventCustomer> eventCustomerConsumer() {

        Map<String,Object> map = new HashMap<>();

        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        map.put(ConsumerConfig.GROUP_ID_CONFIG,"event-customer");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(map,new StringDeserializer(), new JsonDeserializer<>(EventCustomer.class));


    }
}
