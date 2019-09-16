package com.oneexperience.pactjvm.accountservice.model;

public class Account {
    private String id;
    private Long amount;
    private User user;

    public Account() {

    }

    public Account(String id, Long amount, User user) {
        this.id = id;
        this.amount = amount;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public Long getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

}
