package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import javax.security.sasl.SaslClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {
    private UserOutput userOutput;
    private UserInput userInput;
    private BigDecimal currentMoney = new BigDecimal("0");
    private List<Item> items = new ArrayList<>();

    public VendingMachine() {
        this.userInput = new UserInput();
        this.userOutput = new UserOutput();
    }

    public void run() {
        importInventoryFromFile("");
        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display")) {
                // display the vending machine slots
                userOutput.displayVendingItems(items);
            } else if (choice.equals("purchase")) {
                // make a purchase
                purchaseItem();
            } else if (choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public void purchaseItem() {
        while (true) {
            String choice = userInput.getPurchaseOption(currentMoney);
            if (choice.equals("feedmoney")) {
                feedMoney();
            } else if (choice.equals("selectitem")) {

                userOutput.displayVendingItems(items);
                String itemToPurchase = userInput.getItemToPurchase();
                boolean hasSlot = false;
                boolean isInStock = true;

                for (Item item : items) {
                    if (item.getSlot().equalsIgnoreCase(itemToPurchase)) {
                        if (item.getQuantity() == 0) {
                            isInStock = false;
                        }
                        hasSlot = true;
                        if (currentMoney.compareTo(item.getPrice()) >= 0 && isInStock) {
                            currentMoney = currentMoney.subtract(item.getPrice());
                            item.setQuantity(item.getQuantity() - 1);
                        }


                        break;
                    }

                }
                if (!hasSlot) {
                    userOutput.displayMessage("Invalid Selection");
                } else if (!isInStock) {
                    userOutput.displayMessage("Item is out of stock");
                }


            } else if (choice.equals("finish")) {
                userOutput.displayMessage("Transaction Finished");
                currentMoney = new BigDecimal(0);
                break;
            }
        }
    }

    public void feedMoney() {
        BigDecimal[] accepted = new BigDecimal[]{new BigDecimal("1"), new BigDecimal("5"), new BigDecimal("10"), new BigDecimal("20")};
        List<BigDecimal> acceptedList = Arrays.asList(accepted);

        BigDecimal moneyFed = userInput.getMoneyFed();
        if (acceptedList.contains(moneyFed)) {
            System.out.println("Yes, it contains a " + moneyFed);
            currentMoney = currentMoney.add(moneyFed);
        } else {
            System.out.println("No, we don't accept that denomination.");
        }
    }

    public void importInventoryFromFile(String path) {
        File inventoryFile = new File("catering.csv");
        try (Scanner input = new Scanner(inventoryFile)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] itemProps = line.split(",");
                // create new Object
                System.out.println(itemProps[1]);
                String slot = itemProps[0];
                String name = itemProps[1];
                BigDecimal price = new BigDecimal(itemProps[2]);
                String type = itemProps[3];
                Item item = new Item(slot, name, price, type);
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ;
    }


}
