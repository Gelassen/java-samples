package com.dataart.training.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

    public final static String NEWEST = "DESC";

    public final static String OLDEST = "ASC";

    private int userId;

    private String name;

    private String pass;

    private Map<String, String> links;

    private int showedPage;

    private String sorted;

    private String currentLink;

    public Account() {
        links = new HashMap<String, String>();
        showedPage = 0;
        sorted = NEWEST;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShowedPage() {
        return showedPage;
    }

    public void setShowedPage(int showedPage) {
        this.showedPage = showedPage;
    }

    public String getSorted() {
        return sorted;
    }

    public void setSorted(String sorted) {
        this.sorted = sorted;
    }

    public String getCurrentLink() {
        return currentLink;
    }

    public void setCurrentLink(String currentLink) {
        this.currentLink = currentLink;
    }
}
