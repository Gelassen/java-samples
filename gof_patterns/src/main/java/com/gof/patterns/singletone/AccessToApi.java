package com.gof.patterns.singletone;

import com.gof.customer.RemoteOutputAPI;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 14.02.14
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
public class AccessToApi {

    private static AccessToApi instance;

    private RemoteOutputAPI outputAPI = new RemoteOutputAPI();

    private AccessToApi() {}

    public static AccessToApi getInstance() {
        if (instance == null) {
            instance = new AccessToApi();
        }
        return instance;
    }

    public RemoteOutputAPI getOutputAPI() {
        return outputAPI;
    }


}
