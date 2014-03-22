package com.dataart.training.dao;

import com.dataart.training.Feed;
import com.dataart.training.FeedRow;
import com.dataart.training.SqlBuilder;
import com.dataart.training.comparators.NewestFirst;

import java.sql.*;
import java.util.*;

public class FeedDao extends BaseDao{

    public final static int NO_ITEM = -1;

    public final static int MAX_TIME_FRAME = 960000;

    public static final String INSERT_LINK = "INSERT INTO links (link, title) VALUES (?,?);";

    public static final String DELETE_LINK = "DELETE FROM links WHERE title=?;";

    public static final String DELETE_LINK_FROM_ACCOOUNT = "DELETE FROM accounts WHERE link_id=?;";

    public static final String SELECT_LINKS_BY_TITLE = "SELECT * FROM links WHERE title=? LIMIT 1;";

    public static final String SELECT_ID_LINK = "SELECT id FROM links WHERE link=?;";

    public static final String SELECT_ALL_LINKS = "SELECT * FROM links;";

    public static final String INSERT_ACCOUNT = "INSERT INTO accounts (link_id,user_id) VALUES (?,?);";

    public static final String DELETE_FEEDS_BY_LINK = "DELETE FROM feeds WHERE main_link=?;";

    public static final String SELECT_LAST_FEED = "SELECT * FROM feeds WHERE main_link=? ORDER BY id LIMIT 1";

    public static final String INSERT_FEEDS = "INSERT INTO feeds (link,title,desc_cl,date_cl,views,pub_date,main_link,guid) " +
            "VALUES (?,?,?,?,?,?,?,?);";

    public static final String SELECT_FEED_BY_KEY = "SELECT * FROM feeds WHERE guid=?";

    public static final String UPDATE_FEED = "UPDATE feeds SET pub_date=? WHERE link=?;";

    public static final String SELECT_FEEDS_BY_PAGE = "SELECT * FROM feeds WHERE main_link=? " +
            "ORDER BY pub_date DESC LIMIT 10 OFFSET %s";

    public static final String SELECT_ALL_FEEDS = "SELECT * FROM feeds ORDER BY pub_date " +
            "DESC LIMIT 10 OFFSET %s";

    public static final String UPDATE_VIEW_OF_FEED = "UPDATE feeds SET views=? WHERE guid=?;";


    public void updateFeed(String guid) {
        Connection conn = super.getConnection();
        try {
            String currentState = null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM feeds WHERE guid=?");
            ps.setString(1, guid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                currentState = rs.getString("views");
            }
            currentState = "false".equals(currentState) ? "true" : "false";

            ps = conn.prepareStatement(UPDATE_VIEW_OF_FEED);
            ps.setString(1, currentState);
            ps.setString(2, guid);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.debug("Failed to update feed", e);
        }
    }

    public List<Feed> getAllFeedsByPage(final String sort, final String offset) {
        List<Feed> feeds = new ArrayList<Feed>();
        Connection conn = super.getConnection();
        try {
            SqlBuilder builder = new SqlBuilder();
            String sql = builder.getSqlStatement("feeds", null, "pub_date", sort, null, offset);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feed feed = new Feed();
                feed.setId(rs.getInt("id"));
                feed.setGuid(rs.getString("guid"));
                feed.setDate(rs.getString("date_cl"));
                feed.setDescription(rs.getString("desc_cl"));
                feed.setLink(rs.getString("link"));
                feed.setMainLink(rs.getString("main_link"));
                feed.setPubDate(rs.getString("pub_date"));
                feed.setTitle(rs.getString("title"));
                feed.setViewed(rs.getString("views").equals("true") ? true : false);
                feeds.add(feed);
            }
        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return feeds;
    }

    public List<Feed> getFeedsByPage(final String link, final String sort, final String offset) {
        List<Feed> feeds = new ArrayList<Feed>();
        Connection conn = super.getConnection();
        try {
            SqlBuilder builder = new SqlBuilder();
            String sql = builder.getSqlStatement("feeds", "main_link=?", "pub_date", sort, null, offset );
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,link);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feed feed = new Feed();
                feed.setId(rs.getInt("id"));
                feed.setGuid(rs.getString("guid"));
                feed.setDate(rs.getString("date_cl"));
                feed.setDescription(rs.getString("desc_cl"));
                feed.setLink(rs.getString("link"));
                feed.setMainLink(rs.getString("main_link"));
                feed.setPubDate(rs.getString("pub_date"));
                feed.setTitle(rs.getString("title"));
                feed.setViewed(rs.getString("views").equals("true") ? true : false);
                feeds.add(feed);
            }
        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return feeds;
    }

    /**
     * Check if this link exist
     *  yes - get this id and insert in user account
     *  no - insert link, insert feed
     *      if insert into account fails then delete last row from links
     * */
    public void insertLink(final String name, final String feed, final int userId) {
        Connection conn = super.getConnection();
        int rowId = getRowId(feed);
        try {
            if (rowId == -1) {
                PreparedStatement preparedStatement = conn.prepareStatement(INSERT_LINK);
                preparedStatement.setString(1, feed);
                preparedStatement.setString(2, name);
                preparedStatement.executeUpdate();

                rowId = getRowId(feed);
                boolean success = insertAccount(conn, rowId, userId);
                if (!success) {
                    preparedStatement = conn.prepareStatement(DELETE_LINK);
                    preparedStatement.setString(1, name);
                    preparedStatement.executeUpdate();
                }
            } else {
                insertAccount(conn, rowId, userId);
            }

        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
    }

    /**
     *  check if exists
     *  yes - update feed (time)
     *  no - insert feed
     * */
    public void insertFeeds(List<Feed> feeds, final String link) {
        Connection conn = super.getConnection();
        //get last row
        //get his date
        //compare this date with date from new dataset
        //get index and extract new values
        //then save them
        try {
            feeds = extractNewFeeds(feeds, conn, link);
            //for all feeds check uniqie
            for (Feed feed : feeds) {
                PreparedStatement preparedStatement = conn.prepareStatement(SELECT_FEED_BY_KEY);
                preparedStatement.setString(1, feed.getGuid());
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    //if this feed exists
                    preparedStatement = conn.prepareStatement(UPDATE_FEED);
                    preparedStatement.setString(1, feed.getPubDate());
                    preparedStatement.setString(2, feed.getGuid());
                    continue;
                }

                preparedStatement = conn.prepareStatement(INSERT_FEEDS);
                preparedStatement.setString(1, feed.getLink());
                preparedStatement.setString(2, feed.getTitle());
                preparedStatement.setString(3, feed.getDescription());
                preparedStatement.setString(4, String.valueOf(feed.getDate()));
                preparedStatement.setString(5, feed.isViewed() ? "true" : "false");
                preparedStatement.setString(6, feed.getPubDate());
                preparedStatement.setString(7, feed.getMainLink());
                preparedStatement.setString(8, feed.getGuid());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
        } finally {
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("Failed to close connection", e);
                }
            }
        }
    }

    private List<Feed> extractNewFeeds(List<Feed> feeds, Connection conn, String link) throws SQLException {
        PreparedStatement selectLastRow = conn.prepareStatement(SELECT_LAST_FEED);
        selectLastRow.setString(1, link);
        ResultSet rsRows = selectLastRow.executeQuery();
        if (rsRows.next()) {
            String pubDate = rsRows.getString("pub_date");
            int index = getOffset(pubDate, feeds);
            if (index != -1) {
                feeds = feeds.subList(0, index);
            }
        }
        return feeds;
    }

    private int getOffset(final String date, final List<Feed> feeds) {
        Feed feed;
        final int size = feeds.size();
        for (int i = 0; i < size; i++) {
            feed = feeds.get(i);
            boolean isNewer = NewestFirst.firstIsNewer(date, feed.getPubDate());
            if (isNewer)
                return i;
        }
        return -1;
    }


    private boolean timeExpired(long time) {
        return (System.currentTimeMillis() - time) > MAX_TIME_FRAME ? true : false;
    }

    public void deleteFeedFromAccount(final String title) {
        Connection conn = super.getConnection();
        try {
            conn.setAutoCommit(false);
            FeedRow row = getRowByTitle(title);
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_LINK_FROM_ACCOOUNT);
            preparedStatement.setInt(1, row.getLinkId());
            preparedStatement.executeUpdate();

            //get link by title
            //delete link
/*            preparedStatement = conn.prepareStatement(SELECT_LINKS_BY_TITLE);
            preparedStatement.setString(1,title);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String link = rs.getString("link");
                preparedStatement = conn.prepareStatement(DELETE_FEEDS_BY_LINK);
                preparedStatement.setString(1,row.getFeed());
                preparedStatement.executeUpdate();
            }*/
            preparedStatement = conn.prepareStatement(DELETE_FEEDS_BY_LINK);
            preparedStatement.setString(1,row.getFeed());
            preparedStatement.executeUpdate();

            preparedStatement = conn.prepareStatement(DELETE_LINK);
            preparedStatement.setString(1, title);
            preparedStatement.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
            try {
                conn.rollback();
            } catch (SQLException e1) {
                logger.error("Failed to return previous state", e1);
            }
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
    }

    public int getRowId(final String feed) {
        int result = -1;
        Connection conn = super.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ID_LINK);
            preparedStatement.setString(1, feed);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result = rs.getInt("id");
            }
        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return result;
    }

    public FeedRow getRowByTitle(final String title) {
        FeedRow result = new FeedRow();
        Connection conn = super.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_LINKS_BY_TITLE);
            preparedStatement.setString(1, title);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result.setLinkId(rs.getInt("id"));
                result.setFeed(rs.getString("link"));
            }
        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return result;
    }

    public boolean insertAccount(Connection conn, int rowId, int userId) {
        boolean success = false;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setInt(1,rowId);
            preparedStatement.setInt(2,userId);
            preparedStatement.executeUpdate();
            success = true;
        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
        } finally {
            try {
                conn.commit();
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return success;
    }

    public List<FeedRow> getAllLinks() {
        List<FeedRow> result = new ArrayList<FeedRow>();
        Connection conn = super.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_LINKS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                FeedRow feed = new FeedRow(rs.getString("link"));
                feed.setLinkId(rs.getInt("id"));
                feed.setTitle(rs.getString("title"));
                result.add(feed);
            }
        } catch (SQLException e) {
            logger.error("Failed to execute statement", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection", e);
            }
        }
        return result;
    }

}
