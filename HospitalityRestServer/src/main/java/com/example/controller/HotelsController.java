package com.example.controller;

import com.example.model.HotelPropertyEntity;
import com.example.model.HotelsEntity;
import com.example.model.HotelsResponse;
import com.example.service.HotelService;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
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
    public Response getHotelsList(@NotNull @QueryParam("checkIn") Long checkIn,
                                  @NotNull @QueryParam("checkOut") Long checkOut,
                                  @NotNull @QueryParam("capacity") Integer capacity,
                                  @QueryParam("hasPool")  boolean hasPool,
                                  @QueryParam("hasTenisCourt") boolean hasTenisCourt,
                                  @QueryParam("hasWaterslides") boolean hasWaterslides) {

        HotelPropertyEntity property = new HotelPropertyEntity();
        property.setHasPool(hasPool);
        property.setHasTennisCourt(hasTenisCourt);
        property.setHasWaterslides(hasWaterslides);

        List<HotelsResponse> list = hotelService.getAll(checkIn, checkOut, capacity, property);
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
