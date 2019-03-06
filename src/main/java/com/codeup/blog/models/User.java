package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id @GeneratedValue
    private long id;

    @Column (nullable = false, length = 128, unique = true)
    private String username;

    @Column(nullable = false, length = 128, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(long id, String username, String email, String password){
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id;
    }
    public User(String username, String email, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
