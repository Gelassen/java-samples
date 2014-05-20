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
            //FIXME find a solution for issue with price - remove inventory!
            // if not reserved try to make reservation
            InventoriesEntity entity = em.find(InventoriesEntity.class, reservationEntity.getIdInventory());
            succeed = entity == null ? true : false;
            if (entity == null) {
                em.persist(reservationEntity);
                RoomEntity roomEntity = em.find(RoomEntity.class, entity.getIdRoom());
                roomEntity.setBooked(true);
                em.persist(roomEntity);
            }
        } catch (ConstraintViolationException e) {
            String as = new String("asd");
        }
        catch (PersistenceException e) {
            String as = new String("asd");
        }

        return succeed;
    }

}
