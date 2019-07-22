package com.studcouch.studcouch.controller;

import com.studcouch.studcouch.dao.DatabaseAccessObject;
import com.studcouch.studcouch.domain.User;
import com.studcouch.studcouch.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(name = "/")
public class MainController {

    @Autowired DatabaseAccessObject databaseAccessObject;

    @GetMapping("/posts")
    public String getAllPosts() {
        return "this is words from main page";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> sd(@PathVariable int id) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(id)
                .toUri();
        if (true) {
            throw new UserNotFoundException("User with id: " + id + " not found.");
        }

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(databaseAccessObject.getAllUsers(), HttpStatus.OK);
    }

}
