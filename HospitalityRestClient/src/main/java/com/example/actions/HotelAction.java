package com.example.actions;

import com.example.model.HotelPropertyEntity;
import com.example.model.HotelsEntity;
import com.example.service.HotelService;
import com.example.utils.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class HotelAction implements Action {

    private final static String CHECKBOX_TRUE = "on";
    private final static String CHECKBOX_FALSE= "off";

//    @EJB
    private HotelService hotelService = new HotelService();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get hotel list based on check in, check out, region, capacity, amenities

        final String checkin = request.getParameter("checkin");
        final String checkout = request.getParameter("checkout");
        final String capacity = request.getParameter("capacity");
        final String region = request.getParameter("region");

        HotelPropertyEntity hotelProperty = new HotelPropertyEntity();
        hotelProperty.setHasPool(CHECKBOX_TRUE.equals(request.getParameter("hasPool")));
        hotelProperty.setHasTennisCourt(CHECKBOX_TRUE.equals(request.getParameter("hasTenisCourt")));
        hotelProperty.setHasWaterslides(CHECKBOX_TRUE.equals(request.getParameter("hasWaterslides")));
//        com.example.utils.Validator validator = new com.example.utils.Validator();
//        if (!(validator.validDate(checkin) &&
//                validator.validDate(checkout) &&
//                validator.validNumber(capacity))) {
//            // TODO add tips to wrong columns
//            response.sendRedirect("intro.jsp");
//            return;
//        }
        Session session = new Session(request);
        session.setCheckin(checkin);
        session.setCheckout(checkout);
        session.setPeopleCapacity(capacity);
        session.setDays();

        List<HotelsEntity> hotels = hotelService.getHotels(checkin, checkout, Integer.valueOf(capacity), hotelProperty);
        request.setAttribute("hotels", hotels);
        request.getRequestDispatcher("hotels.jsp").forward(request, response);
    }
}
