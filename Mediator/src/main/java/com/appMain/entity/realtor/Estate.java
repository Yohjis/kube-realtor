package com.appMain.entity.realtor;

import com.appMain.entity.realtor.District;
import com.appMain.entity.realtor.Realtor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


@Entity
public class Estate {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String address;
    private Double price;
    private District district;
    private Double rooms;
    private String type;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "realtor_id")
    private Realtor realtor;
// Constructors

    public Estate(){
        defineEstate();
    }

    public Estate(String address, String type, Double price, Double rooms, Realtor realtor){

        this.address = address;
        this.type = type;
        this.price = price;
        this.rooms = rooms;
        this.realtor = realtor;
    }

    public String getAddress() {return address; }
    public UUID getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public Double getPrice(){
        return price;
    }
    public Double getRooms() {return rooms; }
    public District getDistrict() { return district;}
    public Realtor getRealtor(){ return realtor;}
    public void setAddress(String address) {
        this.address = address;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPrice(Double price) {
        if(price > 0) {
            this.price = price;
        }else throw new RuntimeException("Price must be positive"); // catch in implementation
    }
    public void setRooms(Double rooms){ this.rooms = rooms;}
    public void setRealtor(Realtor realtor){this.realtor = realtor;}
    private void defineEstate() { id = UUID.randomUUID(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estate)) return false;
        Estate estate = (Estate) o;
        return Objects.equals(getId(), estate.getId()) &&
                Objects.equals(getType(), estate.getType()) &&
                Objects.equals(getDistrict(), estate.getDistrict()) &&
                Objects.equals(getAddress(), estate.getAddress()) &&
                Objects.equals(getPrice(), estate.getPrice()) &&
                Objects.equals(getRealtor(), estate.getRealtor()) &&
                Objects.equals(getRooms(), estate.getRooms());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getType(), getDistrict(), getPrice(), getRooms(), getRealtor());}

}



/*    @Override
    public String toString() {
        return "Estate {" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                *//*", estateWishList=" + estateWishList +*//*
                '}';
    }*/





