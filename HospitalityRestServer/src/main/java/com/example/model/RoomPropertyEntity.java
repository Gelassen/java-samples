package com.example.model;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "room_property", schema = "", catalog = "mydb")
public class RoomPropertyEntity {
    private int idRoomProperty;
    private Boolean hasTv;
    private Boolean hasBalcony;
    private Boolean hasConditioner;
    private Boolean niceViewOnSea;
    private Boolean niceViewOnPool;
    private Boolean uglyViewFromWindow;

    private RoomEntity room;

    @OneToOne
    @JoinColumn( name = "id_room_property")
    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

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
    public Boolean getHasTv() {
        return hasTv;
    }

    public void setHasTv(Boolean hasTv) {
        this.hasTv = hasTv;
    }

    @Basic
    @Column(name = "has_balcony", columnDefinition = "BIT", length = 1)
    public Boolean getHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(Boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    @Basic
    @Column(name = "has_conditioner", columnDefinition = "BIT", length = 1)
    public Boolean getHasConditioner() {
        return hasConditioner;
    }

    public void setHasConditioner(Boolean hasConditioner) {
        this.hasConditioner = hasConditioner;
    }

    @Basic
    @Column(name = "nice_view_on_sea", columnDefinition = "BIT", length = 1)
    public Boolean getNiceViewOnSea() {
        return niceViewOnSea;
    }

    public void setNiceViewOnSea(Boolean niceViewOnSea) {
        this.niceViewOnSea = niceViewOnSea;
    }

    @Basic
    @Column(name = "nice_view_on_pool", columnDefinition = "BIT", length = 1)
    public Boolean getNiceViewOnPool() {
        return niceViewOnPool;
    }

    public void setNiceViewOnPool(Boolean niceViewOnPool) {
        this.niceViewOnPool = niceViewOnPool;
    }

    @Basic
    @Column(name = "ugly_view_from_window", columnDefinition = "BIT", length = 1)
    public Boolean getUglyViewFromWindow() {
        return uglyViewFromWindow;
    }

    public void setUglyViewFromWindow(Boolean uglyViewFromWindow) {
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
        result = 31 * result + (hasTv ? 1 : 0);
        result = 31 * result + (hasBalcony ? 1 : 0);
        result = 31 * result + (hasConditioner ? 1 : 0);
        result = 31 * result + (niceViewOnSea ? 1 : 0);
        result = 31 * result + (niceViewOnPool ? 1 : 0);
        result = 31 * result + (uglyViewFromWindow ? 1 : 0);
        return result;
    }
}
