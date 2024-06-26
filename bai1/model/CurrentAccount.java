package com.viettinbank.banking.model;

import com.viettinbank.banking.interfaces.Account;

public class CurrentAccount extends GeneralAccount implements Account {
    private double overDraftLimit;

    public CurrentAccount(int bankID, double overDraftLimit, double deposit) {
        super(bankID);
        deposit(deposit);
        this.overDraftLimit = overDraftLimit;
        System.out.println(
                "Savings Account: "
                + "\nInitial Deposit: $" + deposit
                + "\nOverdraftLimit: $" + overDraftLimit
        );
    }

    @Override
    public void deposit(double amount) {
        if (checkAmountDeposit(amount)) {
            setBalance(amount);
            System.out.println("Now deposit " + amount + "to Current Account.");
            return;
        }

        System.out.println("Amount must be greater 0");

    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            System.err.println("Amount must be greater 0");
            return;
        }
        if (amount > overDraftLimit) {
            System.err.println("Exceed the allowable limit");
            return;
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public double interestCalculator() {
        return 0;
    }

    @Override
    public void balance() {
        System.out.println("Account balance: " + getBalance());

    }

    @Override
    public String toString() {
        return "BankID: " + getBankID() +
                " - Balance: " + getBalance() +
                " - Over Draft Limit: " + overDraftLimit;

    }
}
