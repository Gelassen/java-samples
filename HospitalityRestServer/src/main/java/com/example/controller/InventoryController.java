package com.example.controller;

import com.example.model.InventoriesEntity;
import com.example.model.inventory.Inventory;
import com.example.service.InventoryService;

import javax.ejb.EJB;
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
    public Response getInventoriesByHotel(@PathParam("id") String hotelId) {
        List<InventoriesEntity> inventories = inventoryService.getInventoriesByHotel(hotelId);
        return ResponseFactory.response(Response.Status.OK, inventories);
    }

//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getInventoryById(@PathParam("id") String hotelId,
//                                     @QueryParam("inventoryId") String inventoryId) {
//        List<Inventory> inventories = inventoryService.getInventoryById(inventoryId);
//        return ResponseFactory.response(Response.Status.OK, inventories);
//    }

}
