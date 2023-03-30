package com.techelevator.ui;

import com.techelevator.application.Item;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayVendingItems(List<Item> items) {
        // NEED TO SHOW WHEN ITEM IS OUT OF STOCK
        for (Item item : items) {
            NumberFormat formattedPrice = NumberFormat.getCurrencyInstance();
            System.out.println("(" + item.getSlot() + ") " + item.getName() + " \t\t" + formattedPrice.format(item.getPrice()) +
                    "\t\t Quantity remaining: " + item.getQuantity());

        }
    }
}
