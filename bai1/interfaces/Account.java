package com.viettinbank.banking.interfaces;

import java.math.BigDecimal;

public interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double interestCalculator();
    void balance();
}
