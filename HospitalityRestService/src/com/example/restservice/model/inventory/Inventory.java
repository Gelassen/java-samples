package com.example.restservice.model.inventory;

import com.example.restservice.model.reservation.Region;

import java.math.BigDecimal;


public class Inventory {

    private String hotelName;
    private HotelProperty hotelProperty;
    private RoomProperty roomProperty;
    private BigDecimal price;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public HotelProperty getHotelProperty() {
        return hotelProperty;
    }

    public void setHotelProperty(HotelProperty hotelProperty) {
        this.hotelProperty = hotelProperty;
    }

    public RoomProperty getRoomProperty() {
        return roomProperty;
    }

    public void setRoomProperty(RoomProperty roomProperty) {
        this.roomProperty = roomProperty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Inventory ["
                + "hotelName=" + hotelName
                + "hotelProperty=" + hotelProperty
                + "roomProperty=" + roomProperty
                + "price=" + price
                + "]";
    }
}
