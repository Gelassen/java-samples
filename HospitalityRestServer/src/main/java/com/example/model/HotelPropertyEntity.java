package com.example.model;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "hotel_property", schema = "", catalog = "mydb")
public class HotelPropertyEntity {
    private int idHotelProperty;
    private byte hasPool;
    private byte hasTennisCourt;
    private byte hasWaterslides;

    @Id
    @Column(name = "id_hotel_property")
    public int getIdHotelProperty() {
        return idHotelProperty;
    }

    public void setIdHotelProperty(int idHotelProperty) {
        this.idHotelProperty = idHotelProperty;
    }

    @Basic
    @Column(name = "has_pool")
    public byte getHasPool() {
        return hasPool;
    }

    public void setHasPool(byte hasPool) {
        this.hasPool = hasPool;
    }

    @Basic
    @Column(name = "has_tennis_court")
    public byte getHasTennisCourt() {
        return hasTennisCourt;
    }

    public void setHasTennisCourt(byte hasTennisCourt) {
        this.hasTennisCourt = hasTennisCourt;
    }

    @Basic
    @Column(name = "has_waterslides")
    public byte getHasWaterslides() {
        return hasWaterslides;
    }

    public void setHasWaterslides(byte hasWaterslides) {
        this.hasWaterslides = hasWaterslides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelPropertyEntity that = (HotelPropertyEntity) o;

        if (hasPool != that.hasPool) return false;
        if (hasTennisCourt != that.hasTennisCourt) return false;
        if (hasWaterslides != that.hasWaterslides) return false;
        if (idHotelProperty != that.idHotelProperty) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHotelProperty;
        result = 31 * result + (int) hasPool;
        result = 31 * result + (int) hasTennisCourt;
        result = 31 * result + (int) hasWaterslides;
        return result;
    }
}
