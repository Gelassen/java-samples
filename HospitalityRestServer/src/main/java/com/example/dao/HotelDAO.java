package com.example.dao;


import com.example.Constants;
import com.example.model.HotelsEntity;
import com.example.model.inventory.Hotel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by dkazakov on 22.04.2014.
 */
@Stateless
public class HotelDAO {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

    public List<HotelsEntity> getAll() {
        // TODO complete me
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<HotelsEntity> criteria = builder.createQuery(HotelsEntity.class);
        Root<HotelsEntity> root = criteria.from(HotelsEntity.class);
        criteria.select(root);
        TypedQuery<HotelsEntity> resultQuery = em.createQuery(criteria);
        return resultQuery.getResultList();
    }

    public Hotel getHotelById(final String id) {
        // TODO complete me
        return null;
    }

}
