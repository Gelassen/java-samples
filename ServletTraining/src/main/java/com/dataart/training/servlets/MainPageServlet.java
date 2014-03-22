package com.dataart.training.servlets;


import com.dataart.training.actions.Action;
import com.dataart.training.actions.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPageServlet extends HttpServlet{

    private ActionFactory factory = new ActionFactory();

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        /**
         * FIXME in case when user have added new feed app try to reestablish
         * previous state and pass a previous selected feed, the link lose one slash
         * in "http://". I don't find the cause, so I just write a hack that add slash if
         * full url doesn't well formed.
         */
        final String name = getActionName(request);
        final Action action = factory.getAction(name);
        final String url = action.perform(request, response);
        request.getRequestDispatcher(url).
                forward(request, response);

    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String getActionName(final HttpServletRequest request) {
        String path = request.getServletPath();
        if (path.length() == 0)
            return "";

        String[] parts;
        parts = path.split("/");
        if (parts.length > 2)
            return "viewpager";

        return path.substring(1, path.length());
    }
}
