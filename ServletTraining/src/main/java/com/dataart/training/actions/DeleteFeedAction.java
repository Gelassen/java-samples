package com.dataart.training.actions;

import com.dataart.training.beans.Account;
import com.dataart.training.dao.FeedDao;
import com.dataart.training.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteFeedAction implements Action {

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String url = "/rssreader";
        String title = (String) request.getParameter("title");
        if (null != title) {
            FeedDao feedDao = new FeedDao();
            feedDao.deleteFeedFromAccount(title);
        }

        HttpSession session = request.getSession();
        UserDao userModel = new UserDao();
        Account account = (Account) session.getAttribute("account");
        account = userModel.getAccount(account.getName(),account.getPass());
        request.setAttribute("account", account);

        String currentFeed = (String) session.getAttribute("currentFeed");
        if (!currentFeed.equals("")) {
            url = url.concat("/").concat(currentFeed);
        }
        return url;
    }

}
