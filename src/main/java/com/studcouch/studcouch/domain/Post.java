package com.studcouch.studcouch.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //commented because need to write joins, coz hibernate can't create such kind of structure (coz list can not be at column)
    //private List<Hashtags> hashtags;

    private String text;

    private String contacts;

}
