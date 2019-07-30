package com.studcouch.studcouch.controller;

import com.studcouch.studcouch.domain.Post;
import com.studcouch.studcouch.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PostController {


    private PostService postService;

    @Autowired
    public PostController (PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<Object> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Object> createUser(@RequestBody Post post) {
        Post newPost = postService.savePost(post);
        URI location = getLocationURI(newPost.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(post, id);
        URI location = getLocationURI(updatedPost.getId());
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/posts/{id}")
    public Resource<Post> findPostById(@PathVariable long id) {
        Post user = postService.findPostById(id);

        Resource<Post> resource = new Resource<>(user );
        ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllPosts());

        resource.add(link.withRel("all-posts"));
        return resource;
    }

    @DeleteMapping("/posts/{id}")
    public void deletePostById(@PathVariable long id) {
        postService.deletePostById(id);
        getAllPosts();
    }



    private URI getLocationURI(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(id)
                .toUri();
    }


}
