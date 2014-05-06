package com.example.actions;

import com.example.utils.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class BookAction implements Action {
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
        // TODO validate name and phone
        if (name == null || phone == null) {
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
            return;
        }

        // TODO if we have name and phone show confirm booking
        // send order to the server

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
