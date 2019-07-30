package com.studcouch.studcouch.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    private String birth;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Post> posts;

}
