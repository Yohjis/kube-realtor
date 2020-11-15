package com.appMain.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Realtor extends User{

    @OneToMany(mappedBy = "EstatesOnAddress")
    private List<Estate> address;


    public Realtor(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public Realtor() {

    }

    @Override
    public String toString() {
        return super.toString();
    }



    @Override
    public boolean equals(User user) {
        return super.equals(user);
    }

}