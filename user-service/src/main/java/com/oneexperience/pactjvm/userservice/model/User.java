package com.oneexperience.pactjvm.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class User {
    @JsonProperty
    @NotNull
    private String id;
    @NotNull
    @JsonProperty
    private String userName;
    @NotNull
    @JsonProperty
    private String userEmailId;

    public User(String id, String userName, String userEmailId) {
        this.id = id;
        this.userName = userName;
        this.userEmailId = userEmailId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public String getId() {
        return id;
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
