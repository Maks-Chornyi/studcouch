package com.studcouch.studcouch.controller;

import com.studcouch.studcouch.domain.User;
import com.studcouch.studcouch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(name = "/")
public class UserController {


    private UserService userService;
    private MessageSource messageSource;

    @Autowired
    public UserController(MessageSource messageSource, UserService userService) {
        this.messageSource = messageSource;
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public Resource<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);

        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());

        resource.add(link.withRel("all-users"));
        return resource;
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{id}")
    public Resource<User> updateUser(@RequestBody User user, @PathVariable long id) {
        User updatedUser = userService.updateUser(user, id);

        Resource<User> resource = new Resource<>(updatedUser);
        ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());

        resource.add(link.withRel("all-users"));
        return resource;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }


    @GetMapping("/hello-world")
    public String hello() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
