package com.example.service;

import com.example.dao.InventoryDAO;
import com.example.model.InventoriesEntity;
import com.example.model.inventory.Inventory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by dkazakov on 23.04.2014.
 */
@Stateless
@EJB(beanInterface = InventoryService.class, name = "InventoryService")
public class InventoryService {

    @EJB
    private InventoryDAO inventoryDAO;

    public List<InventoriesEntity> getInventoriesByHotel(String hotel) {
        return inventoryDAO.getInventoriesByHotel(hotel);
    }

    public List<Inventory> getInventoryById(String inventory) {
        return inventoryDAO.getInventoryById(inventory);
    }

}
