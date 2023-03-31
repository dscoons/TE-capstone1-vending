package com.techelevator.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    @Before
    public void init(){
        this.vendingMachine = new VendingMachine();
        vendingMachine.importInventoryFromFile();
        vendingMachine.setCurrentMoney(new BigDecimal("20"));
    }

    @Test
    public void makePurchase_(){
        vendingMachine.makePurchase();
        BigDecimal actual = vendingMachine.getCurrentMoney();
        BigDecimal expected = new BigDecimal("18.35");

        Assert.assertEquals(expected, actual);

    }




}