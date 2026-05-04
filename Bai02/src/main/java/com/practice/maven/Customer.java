package com.practice.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp đại diện cho khách hàng.
 */
public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accounts;

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.accounts = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void addAccount(Account account) {
        if (account != null) {
            accounts.add(account);
        }
    }

    /**
     * Lấy thông tin khách hàng và danh sách tài khoản.
     */
    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ". Số lượng tài khoản: " + accounts.size();
    }
}
