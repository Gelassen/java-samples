package com.dataart.training.actions;

import com.dataart.training.beans.Account;
import com.dataart.training.dao.FeedDao;
import com.dataart.training.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddFeedAction implements Action {

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String url = "/rssreader";

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        FeedDao feedDao = new FeedDao();
        String feed = request.getParameter("feed");
        String title = request.getParameter("title");
        int userId = account.getUserId();
        feedDao.insertLink(title, feed, userId);

        UserDao userModel = new UserDao();
        account = userModel.getAccount(account.getName(),account.getPass());
        request.setAttribute("account", account);

        String currentFeed = (String) session.getAttribute("currentFeed");
        if (!currentFeed.equals("")) {
            url = url.concat("/").concat(currentFeed);
        }
        return url;
    }

}
