package com.tele2.assignment.subscriber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;

public class Subscription {
    int id;
    String name;
    double monthlyPrice;
    @JsonIgnore
    Instant lastUpdate;

    public Subscription() {
    }

    public Subscription(int id, String name, double monthlyPrice, Instant lastUpdate) {
        this.id = id;
        this.name = name;
        this.monthlyPrice = monthlyPrice;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
