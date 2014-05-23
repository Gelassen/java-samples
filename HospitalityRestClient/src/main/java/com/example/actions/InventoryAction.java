package com.example.actions;

import com.example.model.InventoriesEntity;
import com.example.service.InventoryService;
import com.example.utils.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class InventoryAction implements Action {

//    @EJB
    private InventoryService inventoryService = new InventoryService();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = new Session(request);
        session.setHotel(request.getParameter("hotel"));
        session.setRegion(request.getParameter("region"));
        session.setDescription(request.getParameter("description"));

        String days = request.getParameter("days");
        if (days != null) {
            String[] pair = days.split("-");
            session.setCheckin(pair[0], false);
            session.setCheckout(pair[1], false);
            session.setDays();
        }

        List<InventoriesEntity> inventories = inventoryService.getInventories(
                String.valueOf(session.getCheckin()),
                String.valueOf(session.getCheckout()),
                session.getPeopleCapacity(),
                request.getParameter("hotel_id"));
        request.setAttribute("days", session.getDays());
        request.setAttribute("inventories", inventories);
        request.getRequestDispatcher("rooms.jsp").forward(request, response);
    }
}
