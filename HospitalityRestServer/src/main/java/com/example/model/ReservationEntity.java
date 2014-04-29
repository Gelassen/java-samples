package com.example.model;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "reservation", schema = "", catalog = "mydb")
public class ReservationEntity {
    private int idInventory;
    private String checkIn;
    private String checkOut;
    private String guestName;
    private String guestPhone;

    @Id
    @Column(name = "id_inventory")
    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    @Basic
    @Column(name = "check_in", columnDefinition="char (100)", length = 7)
    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "check_out", columnDefinition="char(100)")
    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    @Basic
    @Column(name = "guest_name", columnDefinition="char(100)")
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Basic
    @Column(name = "guest_phone", columnDefinition="char(100)")
    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (idInventory != that.idInventory) return false;
        if (checkIn != null ? !checkIn.equals(that.checkIn) : that.checkIn != null) return false;
        if (checkOut != null ? !checkOut.equals(that.checkOut) : that.checkOut != null) return false;
        if (guestName != null ? !guestName.equals(that.guestName) : that.guestName != null) return false;
        if (guestPhone != null ? !guestPhone.equals(that.guestPhone) : that.guestPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInventory;
        result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
        result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
        result = 31 * result + (guestName != null ? guestName.hashCode() : 0);
        result = 31 * result + (guestPhone != null ? guestPhone.hashCode() : 0);
        return result;
    }
}
