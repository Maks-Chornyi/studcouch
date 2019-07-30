package com.studcouch.studcouch.service;

import com.studcouch.studcouch.domain.Post;
import com.studcouch.studcouch.exception.UserNotFoundException;
import com.studcouch.studcouch.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepo postRepo;

    @Autowired
    public PostService (PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    public Post updatePost(Post post, long id) {
        post.setId(id);
        return savePost(post);
    }

    public Post findPostById(long id) {
        Optional<Post> optionalPost =  postRepo.findById(id);

        if(!optionalPost.isPresent()) {
            throw new UserNotFoundException("Post not found");
        }
        return optionalPost.get();
    }

    public void deletePostById(long id) {
        postRepo.deleteById(id);
    }
}
