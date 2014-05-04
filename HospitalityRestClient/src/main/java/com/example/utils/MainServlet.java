package com.example.utils;

import com.example.actions.Action;
import com.example.actions.ActionFactory;
import com.example.service.HotelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class MainServlet extends HttpServlet {

//    @EJB
//    private HotelService com.example.service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processResponse(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processResponse(req, resp);
    }

    private void processResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String path = req.getRequestURI();
        Action action = new ActionFactory().getAction(path);
        action.perform(req, resp);
    }
}
