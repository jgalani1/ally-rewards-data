package com.example.demo.Offers;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OfferData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String card;
    private String offer;
    private String reward;

    public OfferData() {}

    public OfferData(String card, String offer, String reward) {
        this.card = card;
        this.offer = offer;
        this.reward = reward;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCard() {
        return this.card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getOffer() {
        return this.offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getReward() {
        return this.reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }
    
}