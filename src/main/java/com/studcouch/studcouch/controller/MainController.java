package com.studcouch.studcouch.controller;

import com.studcouch.studcouch.dao.DatabaseAccessObject;
import com.studcouch.studcouch.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Locale;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping(name = "/")
public class MainController {

    private DatabaseAccessObject databaseAccessObject;
    private MessageSource messageSource;

    @Autowired
    public MainController(DatabaseAccessObject databaseAccessObject, MessageSource messageSource) {
        this.databaseAccessObject = databaseAccessObject;
        this.messageSource = messageSource;
    }

    @GetMapping("/posts")
    public String getAllPosts() {
        return "this is words from main page";
    }

    @GetMapping("users")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(databaseAccessObject.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public Resource<User> getUserById(@PathVariable long id) {
        User user = databaseAccessObject.getUserById(id);

        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());

        resource.add(link.withRel("all-users"));
        return resource;
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = databaseAccessObject.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
//        return new ResponseEntity("sdfsdfsdfsdfsf", HttpStatus.OK);
    }

    @GetMapping("/hello-world")
    public String hello(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
    }
}
