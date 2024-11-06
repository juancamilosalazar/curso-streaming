package com.quind.io.curso.streaming.service;

import com.quind.io.curso.streaming.model.EventCustomer;

public interface EventCustomerServiceInterface {

    public void consumeRecomendationEngine(EventCustomer eventCustomer);
}
