package com.appMain.entity.dto;

import com.appMain.entity.User;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;


@Entity
public class Client extends User {

    private UUID clientId;
    private Calendar registrationDate;
    private Double cash;

    public Client(UUID clientId, String firstName, String lastName, String email, Double cash){
        super(firstName, lastName, email);
        defineClient();
    }

    public Client() {
    }


    public UUID getClientId(){
        return clientId;
    }
    public void setClientId(UUID clientId){
        this.clientId = clientId;
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
        return super.toString();
    }
    private void defineClient() {
        registrationDate = new GregorianCalendar();
    }

}
