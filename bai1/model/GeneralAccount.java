package com.viettinbank.banking.model;

import java.math.BigDecimal;

public class GeneralAccount {
    private double balance;
    private int bankID;

    public GeneralAccount(int bankID) {
        this.balance = 0;
        this.bankID = bankID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkAmountDeposit(double amount) {
        return amount > 0;
    }

    public int getBankID() {
        return bankID;
    }

}
