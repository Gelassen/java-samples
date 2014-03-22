package com.dataart.training.actions;

import com.dataart.training.Feed;
import com.dataart.training.FeedsModel;
import com.dataart.training.beans.Account;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class ViewPagerAction implements Action {

    private final static int DEFAULT_COUNT = 10;

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getRequestURI();
        String pathWithoutSlash = path.substring(1, path.length());
        String link = pathWithoutSlash.substring(pathWithoutSlash.indexOf('/')+1);

        /**@see com.dataart.training.servlets.MainPageServlet fot details*/
        link = insertSlash(link);

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (!account.getCurrentLink().equals(link)) {
            account.setCurrentLink(link);
            account.setSorted(Account.NEWEST);
            account.setShowedPage(0);
        }

        String page = String.valueOf(account.getShowedPage());
        String sort = account.getSorted();
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements() ;)
        {
            String param= e.nextElement().toString();
            if (param.equals("page")) {
                page = request.getParameter(param);
            } else if (param.equals("sort")) {
                sort = request.getParameter(param);
            }
        }

        int count = Integer.valueOf(page) * DEFAULT_COUNT;
        FeedsModel model = new FeedsModel();
        List<Feed> feeds = model.getFeeds(link, sort, String.valueOf(count));

        account.setShowedPage(Integer.valueOf(page));
        account.setSorted(sort);
        session.setAttribute("account", account);

        request.setAttribute("currentFeed", link);
        request.setAttribute("feeds", feeds);
        return "/index.jsp";
    }

    private String insertSlash(String link) {
        if (!link.contains("http://")) {
            link = link.replaceFirst("/","//");
        }
        return link;
    }
}
