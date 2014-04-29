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
    public Response getHotelsList(@QueryParam("startDate") String startDate,
                                  @QueryParam("endDate") String endDate) {
        List<HotelsEntity> list = hotelService.getAll();
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
