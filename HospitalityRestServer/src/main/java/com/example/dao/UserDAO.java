package com.example.dao;

import com.example.Constants;
import com.example.model.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by dkazakov on 22.04.2014.
 */
@Stateless
public class UserDAO {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT)
    private EntityManager em;

    public Client findClientByLogin(final String login) {
        TypedQuery<Client> query = em.createNamedQuery("findUserByLogin", Client.class);
        query.setParameter("login", login);
        List<Client> clients = query.getResultList();
        return clients.size() == 0 ? new Client() : clients.get(0);
    }

}
