package com.viettinbank.banking.services;

import com.viettinbank.banking.model.CurrentAccount;
import com.viettinbank.banking.model.SavingsAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagementAccount {
    private static final Scanner sc = new Scanner(System.in);
    private ArrayList<CurrentAccount> currentAccounts;
    private ArrayList<SavingsAccount> savingsAccounts;
    private int savingAccountID = 0;
    private int currentAccountID = 0;

    public ManagementAccount() {
        this.currentAccounts = new ArrayList<>();
        this.savingsAccounts = new ArrayList<>();
    }

    public void addNewSavingAccount(int bankID) {
        // bankID of Current Account
        if (isHaveCurrentAccount(bankID)) {
            System.out.println("Savings Account: ");
            System.out.println("Initial Deposit: ");
            double initDeposit = sc.nextDouble();
            System.out.println("Interest rate: ");
            double interestRate = sc.nextDouble();

            SavingsAccount savingsAccount =
                    new SavingsAccount(savingAccountID + 1,interestRate, initDeposit, bankID);
            savingsAccounts.add(savingsAccount);
            System.out.println("---------------------------");
        } else {
            System.out.println("Needed an current account !");
        }
    }

    public void addNewCurrentAccount() {
        System.out.println("Current Account: ");
        System.out.println("Initial Deposit: ");
        double initialDeposit = sc.nextDouble();
        System.out.println("Overdraft limit: ");
        double overDraftLimit = sc.nextDouble();
        CurrentAccount currentAccount = new CurrentAccount(currentAccountID+1,overDraftLimit,initialDeposit);
        currentAccounts.add(currentAccount);
        System.out.println("---------------------------");
    }

    public void applyInterest(int savingBankID) {
        SavingsAccount savingsAccount = getSavingAccount(savingBankID);

        if (savingsAccount != null)
            savingsAccount.applyInterest();
        else
            System.out.println("No saving account found !");
    }

    public void showAccount(String typeAccount) {
        if (typeAccount.equals("saving")) {
            System.out.println("Saving account: ");
            for (SavingsAccount s : savingsAccounts) {
                System.out.println(s.toString());
            }
        } else {
            System.out.println("Current account: ");
            for (CurrentAccount c : currentAccounts) {
                System.out.println(c.toString());
            }
        }
    }

    public boolean isHaveCurrentAccount(int bankID) {
        CurrentAccount currentAccount = currentAccounts.stream()
                .filter(a -> a.getBankID() == bankID)
                .findFirst()
                .orElse(null);
        return currentAccount != null;
    }

    public void checkAccountSize(String typeAccount) throws IllegalArgumentException {
        if (typeAccount.equals("saving")) {
            if (savingsAccounts.isEmpty()) {
                throw new IllegalArgumentException("No account open !");
            }
        }
        if (typeAccount.equals("current")) {
            if (currentAccounts.isEmpty()) {
                throw new IllegalArgumentException("No account open !");
            }
        }
    }

    public SavingsAccount getSavingAccount(int savingAccountID) {

        return savingsAccounts
                .stream()
                .filter(s -> s.getBankID() == savingAccountID)
                .findFirst()
                .orElse(null);
    }

    public CurrentAccount getCurrentAccount(int currentAccountID) {
        return currentAccounts
                .stream()
                .filter(s -> s.getBankID() == currentAccountID)
                .findFirst()
                .orElse(null);
    }

}
