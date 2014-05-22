package com.example.service;


import com.example.model.ReservationEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = BookingService.class, name = "BookingService")
public class BookingService extends Service{

    private boolean created;

    public boolean book(ReservationEntity reservation) {
        created = true;
        execute(HttpMethod.POST, null, ReservationEntity.class, reservation);
        return created;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST)
                .path("rest")
                .path("book");
    }

    @Override
    protected <R> R processClientError(Response response) {
        created = false;
        return null;
    }
}
