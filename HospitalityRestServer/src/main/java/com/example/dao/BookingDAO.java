package com.example.dao;


import com.example.Constants;
import com.example.model.ReservationEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dkazakov on 15.05.2014.
 */
@Stateless
public class BookingDAO {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void makeOrder(ReservationEntity reservationEntity) {
//        em.getTransaction().begin();
        em.persist(reservationEntity);
        //TODO update room table
//        em.getTransaction().commit();
    }

}
