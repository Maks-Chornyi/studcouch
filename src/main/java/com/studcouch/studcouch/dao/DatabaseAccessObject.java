package com.studcouch.studcouch.dao;

import com.studcouch.studcouch.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseAccessObject {
    private static List<User> users = new ArrayList<>();
    private static long userCount = (long) users.size();

    static {
        User user1 = new User();
        user1.setEmail("email1");
        user1.setId(1L);
        user1.setName("name1");

        User user2 = new User();
        user1.setEmail("email1");
        user1.setId(2L);
        user1.setName("name1");

        User user3 = new User();
        user1.setEmail("email1");
        user1.setId(3L);
        user1.setName("name1");

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public List<User> getAllUsers() {
        return users;
    }

}
