package com.example;

import com.example.mocks.HotelMock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


/**
 * User: dkazakov
 * Date: 08.04.14
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("hotels", HotelMock.getHotelList());
//        getServletContext().getRequestDispatcher("/hotels.jsp").forward(req, resp);
        requestHotelList();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private List requestHotelList() {
        try {
            URL server = new URL("http://localhost:8090/hotels");
            HttpURLConnection urlConnection = (HttpURLConnection) server.openConnection();
            final int responseCode = urlConnection.getResponseCode();

            final StringBuffer result = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            //TODO convert to json

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
