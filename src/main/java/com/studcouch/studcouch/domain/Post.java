package com.studcouch.studcouch.domain;

import com.studcouch.studcouch.statics.Hashtags;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private List<Hashtags> hashtags;

    private String text;

    private String contacts;

}
