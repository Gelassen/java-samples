package com.example.restservice.model.reservation;

public class RegionAsTree extends Region {

    private String country;
    private String city;
    private String street;
    private String building;

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        return "RegionAsTree ["
                + "country=" + country
                + "city=" + city
                + "city=" + street
                + "building=" + building +
                "]";
    }

    public RegionAsTree setCountry(String country) {
        this.country = country;
        return this;
    }

    public RegionAsTree setCity(String city) {
        this.city = city;
        return this;
    }

    public RegionAsTree setStreet(String street) {
        this.street = street;
        return this;
    }

    public RegionAsTree setBuilding(String building) {
        this.building = building;
        return this;
    }
}
