package com.studcouch.studcouch.repo;

import com.studcouch.studcouch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
