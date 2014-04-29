package com.example.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by dkazakov on 25.04.2014.
 */
@Entity
@Table(name = "inventories", schema = "", catalog = "mydb")
public class InventoriesEntity {
    private BigDecimal price;
    private int idInventory;

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Id
    @Column(name = "id_inventory")
    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoriesEntity that = (InventoriesEntity) o;

        if (idInventory != that.idInventory) return false;
        if (price != that.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        BigDecimal result = price;
        result = new BigDecimal(31 * result.intValue() + idInventory);
        return result.intValue();
    }
}
