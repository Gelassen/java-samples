package com.example.model;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "reservation_dates", schema = "", catalog = "mydb",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        })
@NamedQueries({
    @NamedQuery(name = "ReservationDates.findAllByHotel",
        query = "select rd from ReservationDatesEntity rd " +
                "where rd.hotelId = :id ")
})
public class ReservationDatesEntity implements HospitalityEntity {
    private int id;
    private long checkIn;
    private long checkOut;
    private int hotelId;

    private HotelsEntity hotel;

    @JsonBackReference("hotel")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "id_hotel", insertable = false, updatable = false )
    public HotelsEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelsEntity hotel) {
        this.hotel = hotel;
    }

    @Id
    @Column(name = "id", columnDefinition="bigint(20)")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Basic
    @Column(name = "id_hotel", columnDefinition="bigint(20)")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
