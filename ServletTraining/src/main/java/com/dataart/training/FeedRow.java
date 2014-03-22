package com.dataart.training;

public class FeedRow {

    private int linkId;

    private String feed;

    private String title;

    public FeedRow() {

    }

    public FeedRow(String url) {
        feed = url;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
