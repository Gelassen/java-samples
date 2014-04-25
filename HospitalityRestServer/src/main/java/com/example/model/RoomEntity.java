package com.example.model;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "room", schema = "", catalog = "mydb")
public class RoomEntity {
    private String idRoom;
    private String roomType;
    private int peopleCapacity;
    private byte booked;
    private byte locked;

    @Id
    @Column(name = "id_room")
    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "room_type")
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Basic
    @Column(name = "people_capacity")
    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    @Basic
    @Column(name = "booked")
    public byte getBooked() {
        return booked;
    }

    public void setBooked(byte booked) {
        this.booked = booked;
    }

    @Basic
    @Column(name = "locked")
    public byte getLocked() {
        return locked;
    }

    public void setLocked(byte locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (booked != that.booked) return false;
        if (locked != that.locked) return false;
        if (peopleCapacity != that.peopleCapacity) return false;
        if (idRoom != null ? !idRoom.equals(that.idRoom) : that.idRoom != null) return false;
        if (roomType != null ? !roomType.equals(that.roomType) : that.roomType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoom != null ? idRoom.hashCode() : 0;
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + peopleCapacity;
        result = 31 * result + (int) booked;
        result = 31 * result + (int) locked;
        return result;
    }
}
