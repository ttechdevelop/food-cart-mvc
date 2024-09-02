package com.ttechdevelop.FoodCart.model.entity;

import java.math.BigDecimal;

public class Food {

    private int id;
    private String item;
    private BigDecimal price;


    public Food(int id, String item, BigDecimal price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
