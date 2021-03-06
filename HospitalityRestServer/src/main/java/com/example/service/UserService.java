package com.example.service;

import com.example.dao.UserDAO;
import com.example.model.Client;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by dkazakov on 22.04.2014.
 */
@Stateless
@EJB(beanInterface = UserService.class, name = "UserService")
public class UserService {

    @EJB
    private UserDAO userDAO;

    public boolean authenticate(final String name, final String password) {
        Client client = userDAO.findClientByLogin(name);
        return !client.empty() && client.checkPassword(password);
    }

}
