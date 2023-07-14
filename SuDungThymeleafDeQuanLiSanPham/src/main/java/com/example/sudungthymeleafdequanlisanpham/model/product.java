package com.example.sudungthymeleafdequanlisanpham.model;

public class product {
    private int id;
    private String name;
    private double cost;
    private String describe;
    private String producer;

    public product(int id, String name, double cost, String describe, String producer) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.describe = describe;
        this.producer = producer;
    }

    public product() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
