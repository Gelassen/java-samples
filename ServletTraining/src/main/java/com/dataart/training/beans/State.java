package com.dataart.training.beans;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 05.11.12
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class State {

    public String currentFeed;

    private String isLogin;

    private String login;

    public String getCurrentFeed() {
        return currentFeed;
    }

    public void setCurrentFeed(String currentFeed) {
        this.currentFeed = currentFeed;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        login = login;
    }


}
