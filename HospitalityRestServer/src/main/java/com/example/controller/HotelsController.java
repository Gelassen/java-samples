package com.example.controller;

import com.example.model.inventory.Hotel;
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

    /**
     * @param startDate Start date of trip in UTC. Can be omitted
     * @param endDate End date of trip in UTC. Can be omitted
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHotelsList(@QueryParam("startDate") String startDate,
                                  @QueryParam("endDate") String endDate) {
        List<Hotel> list = hotelService.getAll();
        return ResponseFactory.response(Response.Status.OK, list);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryByHotel(@PathParam("id") String hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return ResponseFactory.response(Response.Status.OK, hotel);
    }



}
