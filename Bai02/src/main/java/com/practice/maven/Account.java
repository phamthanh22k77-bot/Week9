package com.practice.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp trừu tượng đại diện cho tài khoản ngân hàng.
 */
public abstract class Account {
    public static final String CHECKING_TYPE = "CHECKING";
    public static final String SAVINGS_TYPE = "SAVINGS";

    private long accountNumber;
    private double balance;
    protected List<Transaction> transactions;

    /**
     * Khởi tạo tài khoản.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    protected void doDepositing(double amount) throws BankException {
        if (amount < 0) {
            throw new BankException("Số tiền gửi phải lớn hơn 0");
        }
        this.balance += amount;
    }

    protected void doWithdrawing(double amount) throws BankException {
        if (amount < 0) {
            throw new BankException("Số tiền rút phải lớn hơn 0");
        } else if (amount > balance) {
            throw new BankException("Số dư không đủ");
        }
        this.balance -= amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction t) {
        this.transactions.add(t);
    }

    /**
     * Lấy lịch sử giao dịch.
     */
    public String getTransactionHistory() {
        StringBuilder history = new StringBuilder();
        history.append("Lịch sử giao dịch của tài khoản: ").append(accountNumber).append("\n");
        for (Transaction t : transactions) {
            history.append(t.getTransactionSummary()).append("\n");
        }
        return history.toString();
    }
}
