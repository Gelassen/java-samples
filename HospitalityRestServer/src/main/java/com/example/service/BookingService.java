package com.example.service;

import com.example.dao.BookingDAO;
import com.example.dao.InventoryDAO;
import com.example.model.InventoriesEntity;
import com.example.model.ReservationEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dkazakov on 22.04.2014.
 *
 */
@Stateless
@EJB(beanInterface = BookingService.class, name = "BookingService")
public class BookingService {

    @EJB
    private BookingDAO bookingDAO;

    @EJB
    private InventoryDAO inventoryDAO;

    public boolean makeOrder(@NotNull ReservationEntity reservationEntity) {
        boolean succeed = bookingDAO.makeOrder(reservationEntity);
        if (!succeed) {
            // try to find similar offer
            final int id = reservationEntity.getIdInventory();
            InventoriesEntity inventory = inventoryDAO.getInventoryById(id);
            List<InventoriesEntity> inventories = inventoryDAO.getSimilarInventory(inventory);
            if (inventories.size() == 0) {
                succeed = false;
            } else {
                // Is it thread-safe?
                reservationEntity.setIdInventory(
                        inventories.get(0).getIdInventory()
                );
                succeed = bookingDAO.makeOrder(reservationEntity);
            }
        }

        return succeed;

    }


}
