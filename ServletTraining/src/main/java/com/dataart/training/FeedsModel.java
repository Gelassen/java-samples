package com.dataart.training;

import com.dataart.training.comparators.NewestFirst;
import com.dataart.training.comparators.OldestFirst;
import com.dataart.training.dao.FeedDao;
import com.sun.crypto.provider.DESCipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class FeedsModel {

    private final static Logger logger = LoggerFactory.getLogger(FeedsModel.class);

    private final static String NEWEST = "DESC";

    private final static String stringDateFormat = "EEE, dd MMM yyyy HH:mm:ss z";

    private final static String FIRST = "0";

    public void getFeeds(String link) {
        getFeeds(link, NEWEST, FIRST);
    }

    public List<Feed> getFeeds(String link, String sort, String offset) {
        List<Feed> feeds = new ArrayList<Feed>();
        try {
            FeedDao feedDao = new FeedDao();
            if (offset.equals(FIRST)) {
                RssParser parser = new RssParser(link);
                feeds = parser.parse();
                feedDao.insertFeeds(feeds, link);
            }

            feeds = feedDao.getFeedsByPage(link, sort, offset);
        } catch (SAXException e) {
            logger.error("Failed during parsing feeds", e);
        } catch (ParserConfigurationException e) {
            logger.error("Failed during parsing feeds", e);
        } catch (IOException e) {
            logger.error("Failed during parsing feeds", e);
        }

        return feeds;
    }

    public List<Feed> getAllFeeds(final int count,  String sort, final String offset) {
        List<Feed> result = new ArrayList<Feed>();
        FeedDao feedModel = new FeedDao();
        result = feedModel.getAllFeedsByPage(sort, offset);
        return result;
    }

}
