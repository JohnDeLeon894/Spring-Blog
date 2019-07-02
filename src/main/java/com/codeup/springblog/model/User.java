package com.codeup.springblog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "owner")
    private List<Post> post;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User() { }
//  ~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~**~Getters~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~**~
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
//  ~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~**~Setters~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~**~

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
