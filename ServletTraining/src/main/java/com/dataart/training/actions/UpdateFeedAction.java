package com.dataart.training.actions;

import com.dataart.training.dao.FeedDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFeedAction implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String link = request.getParameter("feed");

        FeedDao model = new FeedDao();
        model.updateFeed(link);

        return "/rssreader";
    }

}
