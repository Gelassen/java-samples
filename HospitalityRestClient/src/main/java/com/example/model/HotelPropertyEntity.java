package com.example.model;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "hotel_property", schema = "", catalog = "mydb")
public class HotelPropertyEntity implements HospitalityEntity {
    private int idHotelProperty;
    private Boolean hasPool;
    private Boolean hasTennisCourt;
    private Boolean hasWaterslides;

    private HotelsEntity hotel;


    @Id
    @Column(name = "id_hotel_property", unique = true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getIdHotelProperty() {
        return idHotelProperty;
    }

    public void setIdHotelProperty(int idHotelProperty) {
        this.idHotelProperty = idHotelProperty;
    }

    @Basic
    @Column(name = "has_pool", columnDefinition = "BIT", length = 1)
    public Boolean getHasPool() {
        return hasPool;
    }

    public void setHasPool(Boolean hasPool) {
        this.hasPool = hasPool;
    }

    @Basic
    @Column(name = "has_tennis_court", columnDefinition = "BIT", length = 1)
    public Boolean getHasTennisCourt() {
        return hasTennisCourt;
    }

    public void setHasTennisCourt(Boolean hasTennisCourt) {
        this.hasTennisCourt = hasTennisCourt;
    }

    @Basic
    @Column(name = "has_waterslides", columnDefinition = "BIT", length = 1)
    public Boolean getHasWaterslides() {
        return hasWaterslides;
    }

    public void setHasWaterslides(Boolean hasWaterslides) {
        this.hasWaterslides = hasWaterslides;
    }

    @JsonBackReference("property")
    @OneToOne(mappedBy = "property")
    public HotelsEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelsEntity hotel) {
        this.hotel = hotel;
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
        result = 31 * result + (hasPool ? 1 : -1);
        result = 31 * result + (hasTennisCourt ? 2 : -2);
        result = 31 * result + (hasWaterslides ? 3 : -3);
        return result;
    }
}
