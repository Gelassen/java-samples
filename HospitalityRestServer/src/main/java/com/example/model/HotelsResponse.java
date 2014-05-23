package com.example.model;

import java.util.List;

/**
 * Created by dkazakov on 23.05.2014.
 */
public class HotelsResponse {
    private int idHotel;
    private String name;
    private String region;
    private String description;
    private String photo;

    private HotelPropertyEntity property;
    private List<RoomEntity> rooms;
    private List<ReservationDatesEntity> reservationDates;

    public static synchronized HotelsResponse creator(HotelsEntity entity) {
        HotelsResponse hotelsResponse = new HotelsResponse();
        hotelsResponse.setIdHotel(entity.getIdHotel());
        hotelsResponse.setDescription(entity.getDescription());
        hotelsResponse.setName(entity.getName());
        hotelsResponse.setPhoto(entity.getPhoto());
        hotelsResponse.setProperty(entity.getProperty());
        hotelsResponse.setRegion(entity.getRegion());
        hotelsResponse.setRooms(entity.getRooms());
        return hotelsResponse;
    }

    public List<ReservationDatesEntity> getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(List<ReservationDatesEntity> reservationDates) {
        this.reservationDates = reservationDates;
    }

    public HotelPropertyEntity getProperty() {
        return property;
    }

    public void setProperty(HotelPropertyEntity property) {
        this.property = property;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
