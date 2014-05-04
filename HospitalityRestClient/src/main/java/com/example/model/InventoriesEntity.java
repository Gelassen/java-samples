package com.example.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "inventories", schema = "", catalog = "mydb")
public class InventoriesEntity {
    private int idInventory;
    private BigDecimal price;
    private int idRoom;
    private int idAmmenities;

    private RoomEntity room;
    private AmmenitiesEntity ammenities;
    private ReservationEntity reservation;

    @OneToOne
    @JoinColumn(name = "id_inventory")
    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inventory")
    public AmmenitiesEntity getAmmenities() {
        return ammenities;
    }

    public void setAmmenities(AmmenitiesEntity ammenities) {
        this.ammenities = ammenities;
    }

    @OneToOne(mappedBy = "inventory")
    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    @Id
    @Column(name = "id_inventory", unique = true, nullable = false)
    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "id_room", nullable = false)
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "id_ammenities", nullable = false)
    public int getIdAmmenities() {
        return idAmmenities;
    }

    public void setIdAmmenities(int idAmmenities) {
        this.idAmmenities = idAmmenities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoriesEntity that = (InventoriesEntity) o;

        if (idInventory != that.idInventory) return false;
        if (idRoom != that.idRoom) return false;
        if (idAmmenities != that.idAmmenities) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInventory;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + idRoom;
        result = 31 * result + idAmmenities;
        return result;
    }
}
