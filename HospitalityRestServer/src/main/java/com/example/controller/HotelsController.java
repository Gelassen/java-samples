package com.example.controller;

import com.example.model.HotelsEntity;
import com.example.service.HotelService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by dkazakov on 22.04.2014.
 */
@Path("/hotels")
public class HotelsController {

    @EJB
    private HotelService hotelService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHotelsList(@QueryParam("checkIn") Long checkIn,
                                  @QueryParam("checkOut") Long checkOut,
                                  @QueryParam("capacity") Integer capacity
                                  /**TODO add region and hotel property*/) {
        List<HotelsEntity> list = hotelService.getAll(checkIn, checkOut, capacity, null);
//        List<FakeClass> l = new ArrayList<FakeClass>();
//        FakeClass fake = new FakeClass();
//        fake.setField("test field");
//        l.add(fake);
        return ResponseFactory.response(Response.Status.OK, list);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryByHotel(@PathParam("id") String hotelId) {
        HotelsEntity hotel = hotelService.getHotelById(hotelId);
        return ResponseFactory.response(Response.Status.OK, hotel);
    }



}
