package com.treebricks.medicorner.data.model;

public class Category {
    Integer logo;
    String name;

    public Category(Integer logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
