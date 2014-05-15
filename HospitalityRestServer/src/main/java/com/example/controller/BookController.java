package com.example.controller;

import com.example.model.ReservationEntity;
import com.example.service.BookingService;

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
    public Response bookRoom(ReservationEntity reservationEntity) {
        boolean notCreated = true;
        bookingService.makeOrder(reservationEntity);
/*        if (notCreated) {
            return ResponseFactory.response(Response.Status.CONFLICT);
        }*/

        return ResponseFactory.response(Response.Status.NO_CONTENT);
    }

}
