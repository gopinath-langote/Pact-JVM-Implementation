package com.vodqa.pact.accountervice;

import java.util.Objects;

public class User {
    private String id;
    private String userName;
    private String userEmailId;

    public User() {
    }

    public User(String id, String userName, String userEmailId) {
        this.id = id;
        this.userName = userName;
        this.userEmailId = userEmailId;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userEmailId, user.userEmailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userEmailId);
    }
}
