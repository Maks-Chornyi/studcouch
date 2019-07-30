package com.studcouch.studcouch.service;

import com.studcouch.studcouch.domain.User;
import com.studcouch.studcouch.exception.UserNotFoundException;
import com.studcouch.studcouch.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(long id) {
        Optional<User> userOptional = userRepo.findById(id);

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with id '" + id + "' not found");
        }

        return userOptional.get();
    }

    public User updateUser(User user, long id) {
        user.setId(id);
        return saveUser(user);
    }

    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }
}
