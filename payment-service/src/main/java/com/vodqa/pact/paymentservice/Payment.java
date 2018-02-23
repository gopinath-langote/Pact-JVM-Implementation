package com.vodqa.pact.paymentservice;

public class Payment {
    private Long id;
    private Long amount;
    private Customer customer;

    public Payment() {

    }

    public Payment(Long id, Long amount, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
