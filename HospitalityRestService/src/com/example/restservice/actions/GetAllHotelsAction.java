package com.example.restservice.actions;

import com.example.restservice.model.inventory.Hotel;
import com.example.restservice.storage.StorageWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class GetAllHotelsAction implements Action {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) {
        // go to database and retrieve list of hotels
        // build a json from this list and send to the user
        Collection<Hotel> hotels = new StorageWrapper().getAllHotels();
//        response.
//        new ObjectMapper().
    }
}
