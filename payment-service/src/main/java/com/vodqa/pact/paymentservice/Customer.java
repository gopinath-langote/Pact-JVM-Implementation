package com.vodqa.pact.paymentservice;

import java.util.Objects;

public class Customer {
    private String name;
    private String emailId;

    public Customer() {
    }

    public Customer(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(name, customer.name) &&
                Objects.equals(emailId, customer.emailId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, emailId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
