package com.studcouch.studcouch.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, message = "Text should have at least 5 characters")
    private String text;

    @Size(min = 1, message = "You should provide your contacts")
    private String contacts;

    @ManyToOne
    @JoinColumn
    private User owner;

}
