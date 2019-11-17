package com.company.parsers;

import java.util.List;

public class Product {
    private String type;
    private String name;
    private String price;
    private String contests;
    private String producer;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getContests() {
        return contests;
    }

    public String getProducer() {
        return producer;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setContests(String contests) {
        this.contests = contests;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Product(String type, String name, String price, String contests, String producer) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.contests = contests;
        this.producer = producer;
    }

    public Product() {

    }


}