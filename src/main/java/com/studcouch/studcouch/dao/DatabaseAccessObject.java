package com.studcouch.studcouch.dao;

import com.studcouch.studcouch.domain.User;
import com.studcouch.studcouch.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DatabaseAccessObject {
    private static List<User> users = new ArrayList<>();
    private static long userCount;

    public List<User> getAllUsers() {
        return users;
    }

    public User createUser(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User getUserById(long id) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getId() == id)
                .findAny();

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with id '" + id + "' not found");
        }

        return userOptional.get();
    }
}
