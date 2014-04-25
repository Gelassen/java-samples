package com.example.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by dkazakov on 22.04.2014.
 */
@Path("/user")
public class UserController {

    @GET
    @Produces("text/html")
    public String getMessage() {
        return "Hello world!";
    }

}
