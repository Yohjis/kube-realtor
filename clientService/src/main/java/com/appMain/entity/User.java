package com.appMain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;

    public User(UUID id, String firstName, String lastName, String email) {


        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public User() {

    }


    @javax.persistence.Id
    public UUID getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() { return lastName; }
    public String getEmail() {
        return email;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {this.lastName = lastName; }
    public void setEmail(String email) {this.email = email; }
    public boolean equals(User user) {
        return user.getFirstName().equals(this.firstName) &&
                user.getLastName().equals(this.lastName) &&
                user.getEmail().equals(this.email) &&
                user.getId().equals(this.id);
    }

}