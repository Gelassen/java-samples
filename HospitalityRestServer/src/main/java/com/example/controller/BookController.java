package com.example.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dkazakov on 23.04.2014.
 */
@Path("/book")
public class BookController {


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response bookRoom(@QueryParam("hotelId") String hotelId,
                             @QueryParam("inventoryId") String inventoryId,
                             @QueryParam("startDate") String startDate,
                             @QueryParam("endDate") String endDate) {

        boolean notCreated = true;
        if (notCreated) {
            return ResponseFactory.response(Response.Status.CONFLICT);
        }

        return ResponseFactory.response(Response.Status.NO_CONTENT);
    }

}
