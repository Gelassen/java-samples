package com.example.restservice.model.reservation;

import java.util.Set;

public class Reservation {

    private Region region;
    private ReservationDates reservationDates;
    private int roomCount;
    private int adultsCount;
    private int childrenCount;
    private Set<Children> childrenTypes;

    public Reservation(final Region region, final ReservationDates reservationDates) {
        this.region = region;
        this.reservationDates = reservationDates;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public void setAdults(int adultsCount) {
        this.adultsCount = adultsCount;
    }

    public void setChildren(int childrenCount, Children... childrenTypes) {
        this.childrenCount = childrenCount;
        for (Children childType : childrenTypes) {
            this.childrenTypes.add(childType);
        }
    }

    public enum Children {
        KINDERGARTEN,
        TEENS,
        STUDENTS
    }

}
