package com.example.controller;

import com.example.model.InventoriesEntity;
import com.example.service.InventoryService;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by dkazakov on 23.04.2014.
 */
@Path("/inventory")
public class InventoryController {

    @EJB
    private InventoryService inventoryService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoriesByHotel(@NotNull @PathParam("id") String hotelId,
                                          @QueryParam("checkIn") String checkIn,
                                          @QueryParam("checkOut") String checkOut) {
        // it can be useful to have checkIn and checkout dates but now we don't need this
        List<InventoriesEntity> inventories = inventoryService.getInventoriesByHotel(hotelId);
        return ResponseFactory.response(Response.Status.OK, inventories);
    }

}
