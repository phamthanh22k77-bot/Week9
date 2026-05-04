package com.practice.maven;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Đại diện cho một giao dịch.
 */
public class Transaction {
    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    /**
     * Chuyển đổi mã loại giao dịch thành chuỗi ký tự mô tả tương ứng.
     *
     * @param type mã loại giao dịch (1, 2, 3, hoặc 4).
     * @return chuỗi mô tả loại giao dịch.
     */
    public static String getTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS:
                return "Rút tiền tiết kiệm";
            default:
                logger.error("Invalid transaction type: {}", type);
                return "Không rõ";
        }
    }

    public String getTransactionSummary() {
        // System.out.println(">>> [LOGGING] summary process started for type: " +
        // this.type);
        logger.info("Bắt đầu xử lý tóm tắt giao dịch cho kiểu: {}", this.type);
        String typeStr = getTypeString(type);
        String initialStr = String.format(Locale.US, "%.2f", initialBalance);
        String amountStr = String.format(Locale.US, "%.2f", amount);
        String finalStr = String.format(Locale.US, "%.2f", finalBalance);
        return "- Kiểu giao dịch: " + typeStr + ". Số dư ban đầu: $" + initialStr + ". Số tiền: $" + amountStr + ". Số dư cuối: $" + finalStr + ".";
    }
}
