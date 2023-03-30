package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import javax.security.sasl.SaslClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine {
    private UserOutput userOutput;
    private UserInput userInput;

    public VendingMachine(){
        this.userInput = new UserInput();
        this.userOutput = new UserOutput();
    }

    public void run()
    {
        while(true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                importInventoryFromFile("fsdf");
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }

    public void importInventoryFromFile(String path){
        File inventoryFile = new File("catering.csv");
        try (Scanner input = new Scanner(inventoryFile)) {

            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] itemProps = line.split(",");
                // create new Object
                System.out.println(itemProps[1]);

            }



        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } ;
    }





















    
}
