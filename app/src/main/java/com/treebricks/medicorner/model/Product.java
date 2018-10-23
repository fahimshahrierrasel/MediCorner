package com.treebricks.medicorner.model;

public class Product {
    String name;
    String currentPrice;
    String previousPrice;
    Integer image;

    public Product() {
    }

    public Product(String name, String currentPrice, String previousPrice, Integer image) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.previousPrice = previousPrice;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(String previousPrice) {
        this.previousPrice = previousPrice;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
