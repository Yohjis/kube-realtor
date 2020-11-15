package com.appMain.entity.dto;

import com.appMain.entity.Realtor;
import com.appMain.entity.Estate;

import java.util.List;

public class RealtorDTO {
    private List<Estate> estates;
    private List<Integer> estatesQuantities;
    private Realtor realtor;

    public RealtorDTO() {
    }

    public RealtorDTO(List<Estate> estates, List<Integer> estatesQuantities, Realtor realtor) {
        this.realtor = realtor;
        this.estatesQuantities = estatesQuantities;
        this.estates = estates;
    }

    public List<Estate> getEstates() {

        return estates;
    }

    public void setEstates(List<Estate> estates) {

        this.estates = estates;
    }

    public List<Integer> getEstatesQuantities() {

        return estatesQuantities;
    }

    public void setEstatesQuantities(List<Integer> estatesQuantities) {
        this.estatesQuantities = RealtorDTO.this.estatesQuantities;
    }

    public Realtor getRealtor() {
        return realtor;
    }

    public void setRealtor(Realtor realtor) {

        this.realtor = realtor;
    }
}