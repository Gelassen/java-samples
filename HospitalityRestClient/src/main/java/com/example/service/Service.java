package com.example.service;

import com.example.json.HosptialityEntityProvider;
import com.example.json.JsonCollection;
import com.example.json.JsonRawProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;

/**
 * Created by dkazakov on 30.04.2014.
 */
public abstract class Service {

    protected static final String HOST = "http://localhost:8080/Rest";
    protected Client client;

    public Service() {
        client = ClientBuilder.newClient();
        client.register(JsonCollection.class);
        client.register(JsonRawProvider.class);
        client.register(HosptialityEntityProvider.class);
    }

    protected abstract UriBuilder preparePath();

}
