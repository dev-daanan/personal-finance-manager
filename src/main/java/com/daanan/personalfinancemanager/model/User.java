package com.daanan.personalfinancemanager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {

    // FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "name")
    private String name;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    // CONSTRUCTORS

    public User( ) {

        this.enabled = true;
    }

    public User(String username, String email, String passwordHash, String name) {

        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = name;
    }

    public User(String defaultUserName, String email, String password, String name, boolean enabled) {

        this.username = defaultUserName;
        this.email = email;
        this.passwordHash = password;
        this.name = name;
        this.enabled = enabled;
    }

    // METHODS

    // GETTERS AND SETTERS


    public int getUserId( ) {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public String getUsername( ) {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getEmail( ) {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPasswordHash( ) {

        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {

        this.passwordHash = passwordHash;
    }

    public String getName( ) {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public boolean isEnabled( ) {

        return enabled;
    }

    public void setEnabled(boolean enabled) {

        this.enabled = enabled;
    }

    public LocalDateTime getRegistrationDate( ) {

        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {

        this.registrationDate = registrationDate;
    }
}
