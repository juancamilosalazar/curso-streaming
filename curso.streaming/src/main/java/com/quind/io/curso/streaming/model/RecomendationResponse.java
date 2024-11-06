package com.quind.io.curso.streaming.model;

import java.util.List;

public class RecomendationResponse {
    private Customer customer;
    private List<String> recomendationList;

    public RecomendationResponse() {
    }

    public RecomendationResponse(Customer customer, List<String> recomendationList) {
        this.customer = customer;
        this.recomendationList = recomendationList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<String> getRecomendationList() {
        return recomendationList;
    }

    public void setRecomendationList(List<String> recomendationList) {
        this.recomendationList = recomendationList;
    }
}
