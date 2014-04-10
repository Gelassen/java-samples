package com.example.model;

import java.io.Serializable;

/**
 * User: dkazakov
 * Date: 08.04.14
 */
public class HotelBean implements Serializable {

    private int id;
    private String name;
    private String region;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
