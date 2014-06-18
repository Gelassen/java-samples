package com.example.dao;


import com.example.Constants;
import com.example.model.InventoriesEntity;
import com.example.model.ReservationEntity;
import com.example.model.RoomEntity;
import org.hibernate.exception.ConstraintViolationException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dkazakov on 15.05.2014.
 */
@Stateless
public class BookingDAO {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

    public boolean makeOrder(ReservationEntity reservationEntity) {
        boolean succeed = false;
        try {
            // FIXME Should I add price for reservation table (for date range)?!
            // if not reserved try to make reservation
            ReservationEntity reservation = em.find(ReservationEntity.class, reservationEntity.getIdInventory());
            succeed = reservation == null ? true : false;
            if (reservation == null) {
                em.persist(reservationEntity);
                InventoriesEntity inventoriesEntity = em.find(
                        InventoriesEntity.class, reservationEntity.getIdInventory()
                );
                // mark room as booked
                RoomEntity roomEntity = em.find(RoomEntity.class, inventoriesEntity.getIdRoom());
                roomEntity.setBooked(true);
                em.persist(roomEntity);
            }
        } catch (ConstraintViolationException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed to insert", e);
        } catch (PersistenceException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Failed", e);
        }

        return succeed;
    }



}
