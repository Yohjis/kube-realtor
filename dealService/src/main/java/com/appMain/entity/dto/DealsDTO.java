package com.appMain.entity.dto;

import com.appMain.entity.Deal;

import java.util.List;

public class DealsDTO {
    private List<Deal> deals;

    public DealsDTO() {
    }

    public DealsDTO(List<Deal> deals) {
        this.deals = deals;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }
}