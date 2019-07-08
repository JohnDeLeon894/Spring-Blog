package com.codeup.springblog.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "posts")
public class Post {

    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "Post must have a title")
    @Size(min = 3, message = "A title must be at least 3 characters.")
    private String title;
    @NotBlank(message = "Post must have a body before you can submit.")
    @Column(nullable = false, columnDefinition = "text")
    private String body;
    @ManyToOne
    private User owner;


    public Post() {

    }

    public Post(String title) {
        this.title = title;
    }

    public Post(String title, String body, User id) {
        this.title = title;
        this.body = body;
        this.owner = id;

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
