package com.example.restservice;

import com.example.restservice.actions.Action;
import com.example.restservice.actions.GetAllHotelsAction;
import com.example.restservice.actions.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *  Support create new hotel and get list of hotels
 * */
public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO complete me
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String path = request.getContextPath();
        Action action = ServletContext.getAction(path);
        action.process(request, response);
    }


}
