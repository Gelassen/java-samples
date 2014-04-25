package com.example.model.inventory;


import com.example.model.reservation.Region;

import java.util.List;

public class Hotel {

    private long hotelId;
    private String name;
    private Region region;
    private List<Inventory> inventories;

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public String toString() {
        return "Hotel ["
                + "hotelId=" + hotelId
                + "name=" + name
                + "Region=" + region
                + "inventories=" + inventories
                + "]";
    }
}
