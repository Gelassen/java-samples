package com.example.actions;

import com.example.model.HotelPropertyEntity;
import com.example.model.HotelsEntity;
import com.example.service.HotelService;
import com.example.utils.Session;
import com.example.utils.validator.Validator;
import com.example.utils.validator.Error;

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
//        final String region = request.getParameter("region");

        HotelPropertyEntity hotelProperty = new HotelPropertyEntity();
        hotelProperty.setHasPool(CHECKBOX_TRUE.equals(request.getParameter("hasPool")));
        hotelProperty.setHasTennisCourt(CHECKBOX_TRUE.equals(request.getParameter("hasTenisCourt")));
        hotelProperty.setHasWaterslides(CHECKBOX_TRUE.equals(request.getParameter("hasWaterslides")));

        // validate fields
        Validator validator = new Validator();
        Error error = new Error();
        error.setCheckinError(!validator.validDate(checkin));
        error.setCheckoutError(!validator.validDate(checkout));
        error.setPeopleError(!validator.validNumber(capacity));

        if (error.isCheckinError() ||
                error.isCheckoutError() ||
                error.isPeopleError()) {

            request.setAttribute("error", error);
            request.getRequestDispatcher("intro.jsp").forward(request, response);
            return;
        }


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
