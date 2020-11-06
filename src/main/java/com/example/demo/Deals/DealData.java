package com.example.demo.Deals;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DealData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String image;
    private String account;
    private String points;
    private String link;

    public DealData() {}

    public DealData(String image, String account, String points, String link) {
        this.image = image;
        this.account = account;
        this.points = points;
        this.link = link;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPoints() {
        return this.points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
