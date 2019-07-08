package com.codeup.springblog.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.mail.Message;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private long id;
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is required")
    @Size(min = 4, message = "Username must be at least 4 characters long")
    private String name;
    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @Column(unique = true, nullable = false)
    @Email(message = "Email must be entered")
    @NotBlank(message = "Email cannot be blank.")
    private String email;
    @OneToMany(mappedBy = "owner")
    private List<Post> post;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User() { }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        name = copy.name;
        password = copy.password;
        post = copy.post;
    }
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
