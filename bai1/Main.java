package com.viettinbank.banking;

import com.viettinbank.banking.model.CurrentAccount;
import com.viettinbank.banking.model.SavingsAccount;
import com.viettinbank.banking.services.ManagementAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final ManagementAccount managementAccount = new ManagementAccount();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        while (true) {
            // Show list main menu in console
            mainMenu();
            System.out.print("Enter your choice: ");
            choose = getUserChoice();

            // Main menu
            switch (choose) {
                // Saving accounts
                case 1:
                    savingAccountMenu();
                    // Display Current Account Menu
                    choose = getUserChoice();
                    switch (choose) {
                        case 1: // add saving account
                            try {
                                // Check current account exits
                                managementAccount.checkAccountSize("current");

                                // Get one current account to open saving account
                                managementAccount.showAccount("current");
                                int bankID = getUserChoice();
                                managementAccount.addNewSavingAccount(bankID);
                            } catch (IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        case 2: // show account in saving account
                            managementAccount.showAccount("saving");
                            break;
                        case 3: // Apply interest
                            try {
                                managementAccount.checkAccountSize("saving");
                                managementAccount.showAccount("saving");
                                int bankID = getUserChoice();
                                managementAccount.applyInterest(bankID);
                            } catch (IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        case 4: // withdraw
                            try {
                                managementAccount.checkAccountSize("saving");

                                managementAccount.showAccount("saving");
                                int bankID = getUserChoice();
                                SavingsAccount savingsAccount = managementAccount.getSavingAccount(bankID);
                                System.out.println("Amount: ");
                                double amount = sc.nextDouble();
                                savingsAccount.withdraw(amount);
                            } catch (IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                    }
                    break;
                // Current Account
                case 2:
                    currentAccountMenu();
                    choose = getUserChoice();
                    switch (choose) {
                        case 1: // add current account
                            managementAccount.addNewCurrentAccount();
                            break;
                        case 2: // show account in current account
                            managementAccount.showAccount("current");
                            break;
                        case 3:
                            try {
                                // Check if current exist
                                managementAccount.checkAccountSize("current");

                                // Show list current account
                                managementAccount.showAccount("current");
                                int bankID = getUserChoice();

                                CurrentAccount currentAccount = managementAccount.getCurrentAccount(bankID);
                                System.out.println("Amount: ");
                                double amount = sc.nextDouble();
                                currentAccount.withdraw(amount);

                            } catch (IllegalArgumentException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                    }
                    break;
            }
        }
    }


    static void mainMenu() {
        System.out.println("--------Banking System--------");
        System.out.println("1.Saving accounts\n2.Current Account\n0. Exit");
    }
    static void currentAccountMenu() {
        System.out.println("1. Add account\n2. List \n3. Withdraw");
    }
    static void savingAccountMenu() {
        System.out.println("1. Add account\n2. List Account\n3. Apply Interest\n4. Withdraw");
    }
    static int getUserChoice() {
        int choice = -1;
        try {
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid input ! Please enter again.");
            sc.nextLine(); // Clear the invalid input
        }
        return choice;
    }
}
