package com.example.model;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "ammenities", schema = "", catalog = "mydb")
public class AmmenitiesEntity implements HospitalityEntity {
    private int idAmmenities;
    private Boolean hasBreakfast;
    private InventoriesEntity inventory;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "id_ammenities")
    public InventoriesEntity getInventory() {
        return inventory;
    }

    public void setInventory(InventoriesEntity inventory) {
        this.inventory = inventory;
    }

    @Id
    @Column(name = "id_ammenities")
    public int getIdAmmenities() {
        return idAmmenities;
    }

    public void setIdAmmenities(int idAmmenities) {
        this.idAmmenities = idAmmenities;
    }

    @Basic
    @Column(name = "has_breakfast", columnDefinition = "BIT", length = 1)
    public Boolean getHasBreakfast() {
        return hasBreakfast;
    }

    public void setHasBreakfast(Boolean hasBreakfast) {
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
        result = 31 * result + (hasBreakfast ? 1 : 0);
        return result;
    }
}
