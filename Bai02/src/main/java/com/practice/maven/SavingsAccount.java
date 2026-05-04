package com.practice.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp SavingsAccount thực thi các quy định về tài khoản tiết kiệm.
 */
public class SavingsAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);
    private static final double MAX_WITHDRAW = 1000.0;
    private static final double MIN_BALANCE = 5000.0;

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        logger.info("Đang xử lý nạp tiền cho tài khoản: {}", getAccountNumber());
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();

            Transaction transaction = new Transaction(
                    Transaction.TYPE_DEPOSIT_SAVINGS, amount, initialBalance, finalBalance);
            addTransaction(transaction);

            logger.info("Nạp tiền thành công: +{}", amount);
        } catch (Exception e) {
            logger.error("Lỗi khi nạp tiền: {}", e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            if (amount > MAX_WITHDRAW) {
                throw new InvalidFundingAmountException(amount);
            }
            if (initialBalance - amount < MIN_BALANCE) {
                throw new InsufficientFundsException(amount);
            }

            doWithdrawing(amount);
            double finalBalance = getBalance();

            Transaction transaction = new Transaction(
                    Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance, finalBalance);
            addTransaction(transaction);

            logger.info("Rút tiền thành công: -{}", amount);
        } catch (Exception e) {
            logger.error("Lỗi khi rút tiền: {}", e.getMessage());
        }
    }
}
