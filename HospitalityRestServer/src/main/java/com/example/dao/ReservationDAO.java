package com.example.dao;


import com.example.Constants;
import com.example.model.ReservationDatesEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dkazakov on 22.04.2014.
 */
@Stateless
public class ReservationDAO {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

    public List<ReservationDatesEntity> getAll(@NotNull int hotelId) {
        TypedQuery<ReservationDatesEntity> resultQuery =  em.createNamedQuery(
                "ReservationDates.findAllByHotel", ReservationDatesEntity.class);
        resultQuery.setParameter("id", hotelId);
        return resultQuery.getResultList();
    }


}
