package com.example.controller;

import com.example.json.GsonFactory;
import com.example.model.ReservationEntity;
import com.example.model.reservation.Reservation;
import com.example.service.BookingService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dkazakov on 23.04.2014.
 */
@Path("/book")
public class BookController {

    @EJB
    private BookingService bookingService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bookRoom(JsonObject reservationEntity) {
        boolean notCreated = true;
        Gson mainGson = GsonFactory.createGson();
        ReservationEntity reservationEntitys = mainGson.fromJson(reservationEntity, ReservationEntity.class);

        // TODO replace me with real data
        ReservationEntity entity = new ReservationEntity();
        entity.setIdInventory(0);
        entity.setCheckIn(1145563200l);
        entity.setCheckOut(1177099200l);
        entity.setGuestName("Dmitry");
        entity.setGuestPhone("258212");
        bookingService.makeOrder(entity/*reservationEntity*/);
/*        if (notCreated) {
            return ResponseFactory.response(Response.Status.CONFLICT);
        }*/

        return ResponseFactory.response(Response.Status.NO_CONTENT);
    }

}
