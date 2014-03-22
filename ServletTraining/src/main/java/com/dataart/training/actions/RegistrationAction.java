package com.dataart.training.actions;

import com.dataart.training.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationAction implements Action{

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String url = "/rssreader";
        String name = (String) request.getParameter("name");
        String pass = (String) request.getParameter("password");
        String repeatedPass = (String) request.getParameter("repeatedPassword");

        UserDao userDao = new UserDao();
        boolean exists = userDao.userExists(name, pass);
        if (pass.equals(repeatedPass) && !exists) {
            userDao.insertUser(name,pass);
            request.setAttribute("isLogin", true);
        } else {
            request.setAttribute("isLogin", false);
            request.setAttribute("error", "User already exists or passwords not equals");
            url = "/authorization";
        }
        return url;
    }

}
