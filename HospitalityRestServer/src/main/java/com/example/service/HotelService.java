package com.example.service;

import com.example.dao.HotelDAO;
import com.example.model.inventory.Hotel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by dkazakov on 22.04.2014.
 *
 * Please ensure that this @link https://java.net/jira/browse/GLASSFISH-20579 issue is resolved
 */
@Stateless
@EJB(beanInterface = HotelService.class, name = "HotelService")
public class HotelService {

    @EJB
    private HotelDAO hotelDAO;

    public List<Hotel> getAll() {
        return hotelDAO.getAll();
    }

    public Hotel getHotelById(final String id) {
        return hotelDAO.getHotelById(id);
    }

}
