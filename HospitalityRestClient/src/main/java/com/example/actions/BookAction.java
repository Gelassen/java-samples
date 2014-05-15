package com.example.actions;

import com.example.model.ReservationEntity;
import com.example.service.BookingService;
import com.example.utils.Session;
import com.example.utils.validator.BookingError;
import com.example.utils.validator.Validator;

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
        // TODO save choosed values, show page
        final String idInventory = request.getParameter("id_inventory");
        if (idInventory != null ) {
            Session session = new Session(request);
            session.setOrder(idInventory);
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
            return;
        }

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

        // TODO if we have name and phone show confirm booking
        // send order to the server
        Session session = new Session(request);
        ReservationEntity reservation = new ReservationEntity();
        reservation.setCheckIn(session.getCheckin());
        reservation.setCheckOut(session.getCheckout());
        reservation.setGuestName(name);
        reservation.setGuestPhone(phone);
        bookingService.book(reservation);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
