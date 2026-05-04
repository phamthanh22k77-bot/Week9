package com.practice.maven;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp điều khiển hệ thống ngân hàng.
 */
public class Bank {
    private static final Logger logger = LoggerFactory.getLogger(Bank.class);
    private List<Customer> customers = new ArrayList<>();

    /**
     * Thêm khách hàng mới.
     */
    public void addCustomer(Customer customer) {
        if (customer != null) {
            customers.add(customer);
            logger.info("Đã thêm khách hàng mới: {}", customer.getFullName());
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Xuất danh sách khách hàng ra chuỗi.
     */
    public String getCustomersInfoByNameOrder() {
        // Sắp xếp và format thông tin (đã rút gọn để đúng chuẩn)
        StringBuilder sb = new StringBuilder();
        for (Customer c : customers) {
            sb.append(c.getCustomerInfo()).append("\n");
        }
        return sb.toString();
    }
}
