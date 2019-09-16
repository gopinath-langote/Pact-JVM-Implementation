package com.oneexperience.pactjvm.userservice.repository;

import com.oneexperience.pactjvm.userservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<String, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User get(String id) {
        return users.get(id);
    }
}
