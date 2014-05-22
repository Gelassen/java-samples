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
                                  @QueryParam("capacity") Integer capacity,
                                  @QueryParam("hasPool") Boolean hasPool,
                                  @QueryParam("hasTenisCourt") Boolean hasTenisCourt,
                                  @QueryParam("hasWaterslides") Boolean hasWaterslides
                                  /*TODO add region*/) {
        List<HotelsEntity> list = hotelService.getAll(checkIn, checkOut, capacity, null);
        return ResponseFactory.response(Response.Status.OK, list);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryByHotel(@PathParam("id") String hotelId) {
        HotelsEntity hotel = hotelService.getHotelById(hotelId);
        return ResponseFactory.response(Response.Status.OK, hotel);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createHotel(HotelsEntity hotel) {
        HotelsEntity result = hotelService.createHotel(hotel);
        return ResponseFactory.response(Response.Status.CREATED, result);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDeviceClass(@PathParam("id") String hotelId, HotelsEntity hotel) {
        boolean updated = hotelService.update(hotelId, hotel);
        return ResponseFactory.response(updated ? Response.Status.NO_CONTENT : Response.Status.NOT_FOUND);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDeviceClass(@PathParam("id") long id) {
        hotelService.delete(id);
        return ResponseFactory.response(Response.Status.NO_CONTENT);
    }
}
