package com.example.model;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "ammenities", schema = "", catalog = "mydb")
public class AmmenitiesEntity {
    private int idAmmenities;
    private byte hasBreakfast;

    @Id
    @Column(name = "id_ammenities")
    public int getIdAmmenities() {
        return idAmmenities;
    }

    public void setIdAmmenities(int idAmmenities) {
        this.idAmmenities = idAmmenities;
    }

    @Basic
    @Column(name = "has_breakfast")
    public byte getHasBreakfast() {
        return hasBreakfast;
    }

    public void setHasBreakfast(byte hasBreakfast) {
        this.hasBreakfast = hasBreakfast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmmenitiesEntity that = (AmmenitiesEntity) o;

        if (hasBreakfast != that.hasBreakfast) return false;
        if (idAmmenities != that.idAmmenities) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAmmenities;
        result = 31 * result + (int) hasBreakfast;
        return result;
    }
}
