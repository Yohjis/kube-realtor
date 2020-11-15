package com.appMain.entity.dto;

import com.appMain.entity.District;

import java.util.UUID;

public class EstateDTO {
    private UUID estateId;
    private String address;
    private Double price;
    private District district;
    private Double rooms;
    private String type;


    public EstateDTO(UUID estateId, String address, Double price, District district, Double rooms, String type){
        this.estateId = estateId;
        this.address = address;
        this.price = price;
        this.district = district;
        this.rooms = rooms;
        this.type = type;
    }


    public UUID getEstateId() {
        return estateId;
    }

    public void setEstateId(UUID estateId) {
        this.estateId = estateId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Double getRooms() {
        return rooms;
    }

    public void setRooms(Double rooms) {
        this.rooms = rooms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
