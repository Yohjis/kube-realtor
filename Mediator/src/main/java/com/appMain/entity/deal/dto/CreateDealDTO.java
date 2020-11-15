package com.appMain.entity.deal.dto;

import com.appMain.entity.deal.Estate;
import com.appMain.entity.deal.Realtor;

import java.util.List;

public class CreateDealDTO {
    private Realtor realtor;
    private Client client;
    private List<Estate> estates;

    public Realtor getRealtor() {
        return realtor;
    }
    public Client getClient() { return client; }
    public List<Estate> getEstates() {
        return estates;
    }

    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}