package com.example.service;


import com.example.model.ReservationEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.UriBuilder;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = BookingService.class, name = "BookingService")
public class BookingService extends Service{

    public boolean book(ReservationEntity reservation /*final String name, final String phone, final String inventoryId*/) {
/*        Type type = new TypeToken<List<InventoriesEntity>>(){}.getType();
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("id_inventory", inventoryId);
        params.put("name", name);
        params.put("phone", phone);

        ReservationEntity reservation = new ReservationEntity();
        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);
        reservation.setGuestName(name);
        reservation.setGuestPhone(phone);*/
        reservation.setIdInventory(6);
        execute(HttpMethod.POST, null, ReservationEntity.class, reservation);
        return true;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST)
                .path("rest")
                .path("book");
    }

}
