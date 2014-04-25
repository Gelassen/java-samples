package com.example.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dkazakov on 22.04.2014.
 */
public class ResponseFactory {

    public static Response response(Response.Status status, Object entity) {
        Response.ResponseBuilder builder = Response.status(status);
        if (entity != null) {
            builder.entity(entity);
        }
        return builder.type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    public static Response response(Response.Status status) {
        return response(status, null);
    }

}
