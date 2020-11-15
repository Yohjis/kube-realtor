package com.estateservice.entity.dto;

import com.estateservice.entity.Estate;

import java.util.List;

public class EstatesDTO {
    private List<Estate> estates;

    public List<Estate> getEstates() {return estates; }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}
