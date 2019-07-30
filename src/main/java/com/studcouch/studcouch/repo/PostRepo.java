package com.studcouch.studcouch.repo;

import com.studcouch.studcouch.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
