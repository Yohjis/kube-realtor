package com.appMain.entity;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.UUID;


@Entity
public class Client extends User {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Calendar registrationDate;
    private Double cash;

    public Client(UUID id, String firstName, String lastName, String email, Double cash){
        super(id, firstName, lastName, email);
        defineClient();
    }

    public Client() {

    }

    private void defineClient() {
    }


    public Double getCash(){
        return  cash;
    }
    public void setCash(Double cash) {
        this.cash = cash;
    }
    public Calendar getRegistrationDate() {

        return registrationDate;
    }
    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email.com=" + email +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
