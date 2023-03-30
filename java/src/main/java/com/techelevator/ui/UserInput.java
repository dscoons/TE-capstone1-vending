package com.techelevator.ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);

    public  String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("d"))
        {
            return "display";
        }
        else if (option.equals("p"))
        {
            return "purchase";
        }
        else if (option.equals("e"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public String getPurchaseOption(BigDecimal currentMoney) {
        NumberFormat moneyFormatted = NumberFormat.getCurrencyInstance();
        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: " + moneyFormatted.format(currentMoney));
        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("m")) {
            return "feedmoney";
        } else if (option.equals("s")) {
            return "selectitem";
        } else if (option.equals("f")) {
            return "finish";
        } else {
            return "";
        }
    }

    public BigDecimal getMoneyFed() {
        System.out.print("How much to add? ");
        String moneyInput = scanner.nextLine();
        BigDecimal money = new BigDecimal(moneyInput);
        return money;
    }
    
}
