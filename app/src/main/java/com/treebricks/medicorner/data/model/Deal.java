package com.treebricks.medicorner.data.model;

public class Deal {
    Integer logo;
    String name;
    String dealText;

    public Deal(Integer logo, String name, String dealText) {
        this.logo = logo;
        this.name = name;
        this.dealText = dealText;
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

    public String getDealText() {
        return dealText;
    }

    public void setDealText(String dealText) {
        this.dealText = dealText;
    }
}
