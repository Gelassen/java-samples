package com.example.model;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "reservation", schema = "", catalog = "mydb",
        uniqueConstraints = { @UniqueConstraint(columnNames = "id_inventory") })
public class ReservationEntity implements HospitalityEntity {
    private NullableWrapper<Integer> idInventory;
    private NullableWrapper<Long> checkIn;
    private NullableWrapper<Long> checkOut;
    private NullableWrapper<String> guestName;
    private NullableWrapper<String> guestPhone;

    private InventoriesEntity inventory;

    @JsonBackReference
    @OneToOne(mappedBy = "reservation")
    public InventoriesEntity getInventory() {
        return inventory;
    }

    public void setInventory(InventoriesEntity inventory) {
        this.inventory = inventory;
    }

    @Id
    @Column(name = "id_inventory")
    public int getIdInventory() {
        return idInventory.getValue();
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = new NullableWrapper<Integer>(idInventory);
    }

    @Basic
    @Column(name = "check_in", columnDefinition="bigint(20)")
    public Long getCheckIn() {
        return checkIn.getValue();
    }

    public void setCheckIn(Long checkIn) {
        this.checkIn = new NullableWrapper<Long>(checkIn);
    }

    @Basic
    @Column(name = "check_out", columnDefinition="bigint(20)")
    public Long getCheckOut() {
        return checkOut.getValue();
    }

    public void setCheckOut(Long checkOut) {
        this.checkOut = new NullableWrapper<Long>(checkOut);
    }

    @Basic
    @Column(name = "guest_name", columnDefinition="char(100)")
    public String getGuestName() {
        return guestName.getValue();
    }

    public void setGuestName(String guestName) {
        this.guestName = new NullableWrapper<String>(guestName);
    }

    @Basic
    @Column(name = "guest_phone", columnDefinition="char(100)")
    public String getGuestPhone() {
        return guestPhone.getValue();
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = new NullableWrapper<String>(guestPhone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (idInventory != that.idInventory) return false;
//        if (checkIn != null ? !checkIn.equals(that.checkIn) : that.checkIn != null) return false;
        if (checkOut != null ? !checkOut.equals(that.checkOut) : that.checkOut != null) return false;
        if (guestName != null ? !guestName.equals(that.guestName) : that.guestName != null) return false;
        if (guestPhone != null ? !guestPhone.equals(that.guestPhone) : that.guestPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInventory.getValue();
//        result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
        result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
        result = 31 * result + (guestName != null ? guestName.hashCode() : 0);
        result = 31 * result + (guestPhone != null ? guestPhone.hashCode() : 0);
        return result;
    }
}
