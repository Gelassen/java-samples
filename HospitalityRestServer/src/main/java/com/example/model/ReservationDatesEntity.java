package com.example.model;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "reservation_dates", schema = "", catalog = "mydb",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        })
public class ReservationDatesEntity implements HospitalityEntity {
    private int id;
    private long checkIn;
    private long checkOut;
    private long hotelId;

    @Id
    @Column(name = "id", columnDefinition="bigint(20)")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_hotel", columnDefinition="bigint(20)")
    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "check_in", columnDefinition="bigint(20)")
    public Long getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Long checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "checkout", columnDefinition="bigint(20)")
    public Long getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Long checkOut) {
        this.checkOut = checkOut;
    }


}
