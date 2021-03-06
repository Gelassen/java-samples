package com.example.dao;

import com.example.Constants;
import com.example.model.InventoriesEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkazakov on 23.04.2014.
 */
@Stateless
public class InventoryDAO {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

    public List<InventoriesEntity> getInventoriesByHotel(String hotel) {
        // TODO complete me
        TypedQuery<InventoriesEntity> query = em.createNamedQuery(
                "InventoriesEntity.getInventoryByHotel", InventoriesEntity.class);
        query.setParameter("idHotel", Integer.valueOf(hotel));
        List<InventoriesEntity> list =  query.getResultList();
        return list;
    }

    public InventoriesEntity getInventoryById(int inventoryId) {
        // TODO complete me
        return new InventoriesEntity();
    }

    public List<InventoriesEntity> getSimilarInventory(InventoriesEntity inventory) {
        // TODO complete me
        return new ArrayList<InventoriesEntity>();
    }

}
