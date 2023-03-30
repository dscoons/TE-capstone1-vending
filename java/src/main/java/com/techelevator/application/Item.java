package com.techelevator.application;

import java.math.BigDecimal;

public class Item {
    private String name;
    private String slot;
    private BigDecimal price;
    private int quantity;
    private String type;

    public Item(String slot, String name, BigDecimal price, String type) {
        this.name = name;
        this.slot = slot;
        this.price = price;
        this.quantity = 6;
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getSlot() {
        return slot;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        if (type.equals("Drink")) {
            return "Drinky, Drinky, Slurp Slurp!";
        } else if (type.equals("Munchy")) {
            return "Munchy, Munchy, so Good!";
        } else if (type.equals("Candy")) {
            return "Sugar, Sugar, so Sweet!";
        } else if (type.equals("Gum")) {
            return "Chewy, Chewy, Lots O Bubbles!";
        }
        // REPLACE THIS LATER
        return "";
    }
}
