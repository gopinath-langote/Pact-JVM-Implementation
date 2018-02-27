package com.vodqa.pact.customerservice;

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

}
