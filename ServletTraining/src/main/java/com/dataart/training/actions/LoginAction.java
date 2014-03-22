package com.dataart.training.actions;

import com.dataart.training.beans.Account;
import com.dataart.training.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction implements Action {

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String name = (String) request.getParameter("name");
        String pass = (String) request.getParameter("password");

        UserDao userDao = new UserDao();
        boolean userExists = userDao.userExists(name, pass);
        request.setAttribute("isLogin", userExists);

        if (userExists) {
            request.setAttribute("login", name);
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            account = userDao.getAccount(name, pass);
            account.setName(name);
            account.setPass(pass);
            session.setAttribute("account", account);
        }

        return "/rssreader";
    }

}
