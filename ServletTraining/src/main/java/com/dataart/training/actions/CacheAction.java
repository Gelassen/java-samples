package com.dataart.training.actions;

import com.dataart.training.FeedRow;
import com.dataart.training.FeedsModel;
import com.dataart.training.dao.FeedDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CacheAction implements Action{

    private final ThreadPoolExecutor pool = new ThreadPoolExecutor(
            4, 6, 2, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        FeedDao feedDao = new FeedDao();
        List<FeedRow> links = feedDao.getAllLinks();
        for (FeedRow link : links) {
            Task r = new Task();
            r.setLink(link.getFeed());
            pool.execute(r);
        }
        pool.shutdown();
        return "/rssreader";
    }

    private class Task implements Runnable {

        private FeedsModel model;

        private String link;

        public Task() {
            model = new FeedsModel();
        }

        @Override
        public void run() {
            model.getFeeds(link);
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

}
