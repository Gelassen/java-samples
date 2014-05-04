package com.example.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class InventoryAction implements Action {

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) {
        // TODO handle params and perform query
        final String hotelId = request.getParameter("hotel_id");
    }
}
