package com.example.actions;

import com.example.model.ReservationEntity;
import com.example.service.BookingService;
import com.example.utils.Session;
import com.example.utils.validator.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class BookAction implements Action {

    private BookingService bookingService = new BookingService();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // process request from inventory page
        final String idInventory = request.getParameter("id_inventory");
        if (idInventory != null ) {
            Session session = new Session(request);
            session.setOrder(idInventory);
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
            return;
        }

        // process request from booking page
        final String name = (String) request.getParameter("customer_name");
        final String phone = (String) request.getParameter("customer_phone");

        Validator validator = new Validator();
        BookingError error = new BookingError();
        error.setNameError(!validator.validateName(name));
        error.setPhoneError(!validator.validatePhone(phone));
        if (error.isNameError() ||
                error.isPhoneError()) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
            return;
        }

        // send order to the server
        Session session = new Session(request);
        ReservationEntity reservation = new ReservationEntity();
        reservation.setCheckIn(session.getCheckin());
        reservation.setCheckOut(session.getCheckout());
        reservation.setGuestName(name);
        reservation.setGuestPhone(phone);

        final boolean created = bookingService.book(reservation);
        OrderError orderError = new OrderError();
        orderError.setNoSimilarRooms(!created);

        request.setAttribute("error", orderError);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
