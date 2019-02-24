package com.vodqa.pact.userservice;

import java.util.Objects;

public class User {
    private String userName;
    private String emailId;

    public User() {
    }

    public User(String userName, String emailId) {
        this.userName = userName;
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(emailId, user.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, emailId);
    }
}
