package com.viettinbank.banking.model;

import com.viettinbank.banking.interfaces.Account;

public class SavingsAccount extends GeneralAccount implements Account {
    private double interestRate;
    private int currentAccountID;

    public SavingsAccount(int bankID, double interestRate, double amount, int currentAccountID) {
        super(bankID);
        deposit(amount);
        this.interestRate = interestRate;
        this.currentAccountID = currentAccountID;
        System.out.println(
                "Savings Account: \n"
                + "Initial Deposit: $" + amount
                + "\nInterest rate: " + interestRate + "%"
                + "\nCurrent Account ID: " + currentAccountID
        );
    }

    @Override
    public void deposit(double amount) {
        if (checkAmountDeposit(amount)) {
            setBalance(getBalance() + amount);
            System.out.println("Now deposit " + amount +" to Savings Account.");
            return;
        }
        System.out.println("Amount must be greater 0");
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            System.err.println("Insufficient balance");
        }
    }

    @Override
    public double interestCalculator() {
        return interestRate/100 * getBalance();
    }

    @Override
    public void balance() {
        System.out.println("Account balance: " + getBalance());
    }

    public void applyInterest() {
        double balance = getBalance() + interestCalculator();
        setBalance(balance);
        System.out.println("Apply interest success, current balance: " + getBalance());
    }

    @Override
    public String toString() {
        return "BankID: " + getBankID() +
                " - Balance: " + getBalance() +
                " - Interest Rate: " + interestRate +
                " - Current Account ID: " + currentAccountID;

    }
}
