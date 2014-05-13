package com.example.dao;


import com.example.Constants;
import com.example.model.HotelPropertyEntity;
import com.example.model.HotelsEntity;

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
public class HotelDAO {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

    public List<HotelsEntity> getAll() {
        TypedQuery<HotelsEntity> resultQuery =  em.createNamedQuery("HotelsEntity.findAll", HotelsEntity.class);
        List<HotelsEntity> list = resultQuery.getResultList();
        return list;
    }

    public List<HotelsEntity> getAll(@NotNull Long checkIn, @NotNull Long checkOut,
                                     @NotNull int capacity, HotelPropertyEntity property) {
        TypedQuery<HotelsEntity> resultQuery =  em.createNamedQuery("HotelsEntity.findAllWithFilter", HotelsEntity.class);
        resultQuery.setParameter("checkin", checkIn);
        resultQuery.setParameter("checkout", checkOut);
        resultQuery.setParameter("capacity", capacity);
        resultQuery.setParameter("pool", property == null ? false : property.getHasPool());
        resultQuery.setParameter("tennis", property == null ? false : property.getHasTennisCourt());
        resultQuery.setParameter("waterslides", property == null ? false : property.getHasWaterslides());
        return resultQuery.getResultList();
    }

    public HotelsEntity getHotelById(@NotNull String hotelId) {
        // TODO complete me
        return null;
    }

}
