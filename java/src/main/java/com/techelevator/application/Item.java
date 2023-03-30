package com.techelevator.application;

import java.math.BigDecimal;

public class Item {
    private String name;
    private String slot;
    private BigDecimal price;
    private int quantity;
    private String type;

    public Item(String name, String slot, BigDecimal price, String type) {
        this.name = name;
        this.slot = slot;
        this.price = price;
        this.quantity = 6;
        this.type = type;
    }



}
