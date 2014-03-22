package com.dataart.training.actions;

import com.dataart.training.Feed;
import com.dataart.training.FeedRow;
import com.dataart.training.FeedsModel;
import com.dataart.training.beans.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MainAction implements Action {

    private final static int DEFAULT_COUNT = 10;

    private final static String ALL_FEEDS = "all";

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String currentLink = account.getCurrentLink();
        if (null == currentLink || !currentLink.equals(ALL_FEEDS)) {
            account.setCurrentLink(ALL_FEEDS);
            account.setSorted(Account.NEWEST);
            account.setShowedPage(0);
        }
        String sort = account.getSorted();
        String page = String.valueOf(account.getShowedPage());

        for (Enumeration e = request.getParameterNames(); e.hasMoreElements() ;)
        {
            String param = e.nextElement().toString();
            if (param.equals("page")) {
                page = request.getParameter(param);
            } else if (param.equals("sort")) {
                sort = request.getParameter(param);
            }
        }
        int count = Integer.valueOf(page) * DEFAULT_COUNT;
        List<FeedRow> feedRows = new ArrayList<FeedRow>();
        FeedsModel model = new FeedsModel();
        List<Feed> feeds = model.getAllFeeds(DEFAULT_COUNT, sort, String.valueOf(count));

        account.setSorted(sort);
        account.setShowedPage(Integer.valueOf(page));
        session.setAttribute("account", account);

        request.setAttribute("currentFeed", ALL_FEEDS);
        request.setAttribute("feedRows", feedRows);
        request.setAttribute("feeds", feeds);
        return "/index.jsp";
    }

}
