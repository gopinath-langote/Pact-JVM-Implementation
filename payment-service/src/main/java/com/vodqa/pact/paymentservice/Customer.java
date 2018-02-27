package com.vodqa.pact.paymentservice;

import java.util.Objects;

public class Customer {
    private String customerName;
    private String emailId;

    public Customer() {
    }

    public Customer(String customerName, String emailId) {
        this.customerName = customerName;
        this.emailId = emailId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerName, customer.customerName) &&
                Objects.equals(emailId, customer.emailId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customerName, emailId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
