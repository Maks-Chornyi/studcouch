package com.studcouch.studcouch.dao;

import com.studcouch.studcouch.domain.User;
import com.studcouch.studcouch.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class DatabaseAccessObject {
    private static List<User> users = new ArrayList<>();
    private static long userCount;

    static {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("name1");
        user1.setBirth(new Date());

        User user2 = new User();
        user2.setId(2L);
        user2.setName("name2");
        user2.setBirth(new Date());

        User user3 = new User();
        user3.setId(3L);
        user3.setName("name3");
        user3.setBirth(new Date());

        users.add(user1);
        users.add(user2);
        users.add(user3);

        userCount = users.size();
    }

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
