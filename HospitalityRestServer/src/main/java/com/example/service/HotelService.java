package com.example.service;

import com.example.dao.HotelDAO;
import com.example.dao.ReservationDAO;
import com.example.model.HotelPropertyEntity;
import com.example.model.HotelsEntity;
import com.example.model.HotelsResponse;
import com.example.model.ReservationDatesEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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

    @EJB
    private ReservationDAO reservationDAO;


    public List<HotelsEntity> getAll() {
        return hotelDAO.getAll();
    }

    public List<HotelsResponse> getAll(@NotNull Long checkIn, @NotNull Long checkOut,
                                     @NotNull int capacity, HotelPropertyEntity property) {
        List<HotelsResponse> result = new ArrayList<HotelsResponse>();
        List<HotelsEntity> hotels = hotelDAO.getAll(checkIn, checkOut, capacity, property);
        for (HotelsEntity hotel : hotels) {
            List<ReservationDatesEntity> reservationDates = reservationDAO.getAll(hotel.getIdHotel());
            HotelsResponse hotelsResponse = HotelsResponse.creator(hotel);
            hotelsResponse.setReservationDates(reservationDates);
            result.add(hotelsResponse);
        }
        return result;
    }

    public HotelsEntity getHotelById(final String id) {
        return hotelDAO.getHotelById(id);
    }

    public HotelsEntity createHotel(@NotNull HotelsEntity hotel) {
        return hotelDAO.createHotel(hotel);
    }

    public boolean update(@NotNull String hotelId, @NotNull HotelsEntity hotel) {
        HotelsEntity stored = hotelDAO.getHotelById(hotelId);
        if (stored == null) return false;

        if (dataExists(hotel.getName())) {
            stored.setName(hotel.getName());
        }
        if (dataExists(hotel.getDescription())) {
            stored.setDescription(hotel.getDescription());
        }
        if (dataExists(hotel.getRegion())) {
            stored.setRegion(hotel.getRegion());
        }
        if (dataExists(hotel.getPhoto())) {
            stored.setPhoto(hotel.getPhoto());
        }
        hotelDAO.update(hotel);
        return true;
    }

    private <T> boolean dataExists(T data) {
        return data != null;
    }

    public void delete(@NotNull long id) {
        hotelDAO.delete(id);
    }
}
