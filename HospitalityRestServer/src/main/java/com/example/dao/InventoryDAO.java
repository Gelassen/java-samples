package com.example.dao;

import com.example.model.inventory.Inventory;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkazakov on 23.04.2014.
 */
@Stateless
public class InventoryDAO {

    public List<Inventory> getInventoriesByHotel(String hotel) {
        // TODO complete me
        return new ArrayList<Inventory>();
    }

    public List<Inventory> getInventoryById(String inventory) {
        // TODO complete me
        return new ArrayList<Inventory>();
    }

}
