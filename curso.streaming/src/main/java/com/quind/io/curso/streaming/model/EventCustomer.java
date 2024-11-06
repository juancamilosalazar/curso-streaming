package com.quind.io.curso.streaming.model;

public class EventCustomer {
    private Customer customer;
    private String event;


    public EventCustomer() {
    }

    public EventCustomer(Customer customer, String event) {
        this.customer = customer;
        this.event = event;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
