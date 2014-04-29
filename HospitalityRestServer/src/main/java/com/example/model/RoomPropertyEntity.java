package com.example.model;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "room_property", schema = "", catalog = "mydb")
public class RoomPropertyEntity {
    private int idRoomProperty;
    private byte hasTv;
    private byte hasBalcony;
    private byte hasConditioner;
    private byte niceViewOnSea;
    private byte niceViewOnPool;
    private int uglyViewFromWindow;

    @Id
    @Column(name = "id_room_property")
    public int getIdRoomProperty() {
        return idRoomProperty;
    }

    public void setIdRoomProperty(int idRoomProperty) {
        this.idRoomProperty = idRoomProperty;
    }

    @Basic
    @Column(name = "has_tv", columnDefinition = "BIT", length = 1)
    public byte getHasTv() {
        return hasTv;
    }

    public void setHasTv(byte hasTv) {
        this.hasTv = hasTv;
    }

    @Basic
    @Column(name = "has_balcony", columnDefinition = "BIT", length = 1)
    public byte getHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(byte hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    @Basic
    @Column(name = "has_conditioner", columnDefinition = "BIT", length = 1)
    public byte getHasConditioner() {
        return hasConditioner;
    }

    public void setHasConditioner(byte hasConditioner) {
        this.hasConditioner = hasConditioner;
    }

    @Basic
    @Column(name = "nice_view_on_sea", columnDefinition = "BIT", length = 1)
    public byte getNiceViewOnSea() {
        return niceViewOnSea;
    }

    public void setNiceViewOnSea(byte niceViewOnSea) {
        this.niceViewOnSea = niceViewOnSea;
    }

    @Basic
    @Column(name = "nice_view_on_pool", columnDefinition = "BIT", length = 1)
    public byte getNiceViewOnPool() {
        return niceViewOnPool;
    }

    public void setNiceViewOnPool(byte niceViewOnPool) {
        this.niceViewOnPool = niceViewOnPool;
    }

    @Basic
    @Column(name = "ugly_view_from_window", columnDefinition = "BIT", length = 1)
    public int getUglyViewFromWindow() {
        return uglyViewFromWindow;
    }

    public void setUglyViewFromWindow(int uglyViewFromWindow) {
        this.uglyViewFromWindow = uglyViewFromWindow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomPropertyEntity that = (RoomPropertyEntity) o;

        if (hasBalcony != that.hasBalcony) return false;
        if (hasConditioner != that.hasConditioner) return false;
        if (hasTv != that.hasTv) return false;
        if (idRoomProperty != that.idRoomProperty) return false;
        if (niceViewOnPool != that.niceViewOnPool) return false;
        if (niceViewOnSea != that.niceViewOnSea) return false;
        if (uglyViewFromWindow != that.uglyViewFromWindow) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoomProperty;
        result = 31 * result + (int) hasTv;
        result = 31 * result + (int) hasBalcony;
        result = 31 * result + (int) hasConditioner;
        result = 31 * result + (int) niceViewOnSea;
        result = 31 * result + (int) niceViewOnPool;
        result = 31 * result + uglyViewFromWindow;
        return result;
    }
}
