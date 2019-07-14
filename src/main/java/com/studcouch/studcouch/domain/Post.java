package com.studcouch.studcouch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hashTags;


    private String text;


    private String contacts;

    public Post(Long id, String hashtags, String text, String contacts) {
        this.id = id;
        this.hashTags = hashtags;
        this.text = text;
        this.contacts = contacts;
    }

    public Post() {

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(hashTags, post.hashTags) &&
                Objects.equals(text, post.text) &&
                Objects.equals(contacts, post.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hashTags, text, contacts);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashTags() {
        return hashTags;
    }

    public void setHashTags(String hashTags) {
        this.hashTags = hashTags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
