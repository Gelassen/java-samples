package com.example.service;

import com.example.Constants;
import com.example.dao.BookingDAO;
import com.example.model.ReservationEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

/**
 * Created by dkazakov on 22.04.2014.
 *
 */
@Stateless
@EJB(beanInterface = BookingService.class, name = "BookingService")
public class BookingService {

    @EJB
    private BookingDAO bookingDAO;

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

//    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Transactional
    public void makeOrder(@NotNull ReservationEntity reservationEntity) {
        em.persist(reservationEntity);
//        bookingDAO.makeOrder(reservationEntity);
        String str = new String("asd");
    }


}
