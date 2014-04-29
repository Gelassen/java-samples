package com.example.dao;


import com.example.Constants;
import com.example.model.HotelsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by dkazakov on 22.04.2014.
 */
@Stateless
public class HotelDAO {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

//    @Inject
//    private EntityManager em;

    public List<HotelsEntity> getAll() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
//        EntityManager em = emf.createEntityManager();

        // TODO complete me
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<HotelsEntity> criteria = builder.createQuery(HotelsEntity.class);
//        Root<HotelsEntity> root = criteria.from(HotelsEntity.class);
//        criteria.select(root);
        TypedQuery<HotelsEntity> resultQuery = em.createQuery("select h from HotelsEntity h", HotelsEntity.class);//em.createQuery(criteria);
        return resultQuery.getResultList();
    }

    public HotelsEntity getHotelById(final String id) {
        // TODO complete me
        return null;
    }

}
