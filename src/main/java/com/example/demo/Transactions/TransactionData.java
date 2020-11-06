package com.example.demo.Transactions;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String date;
    private String amount;
    private String description;
    private String location;

    public TransactionData() {
    }

    public TransactionData(String date, String amount, String description, String location) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.location = location;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
