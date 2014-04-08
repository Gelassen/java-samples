package com.example.restservice.storage;

import com.example.restservice.model.inventory.Hotel;
import com.example.restservice.storage.handlers.HotelsHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StorageWrapper {

    public Collection<Hotel> getAllHotels() {
        return new MySqlStorage().execute(
                new Query().select().from("Hotels").create(),
                new HotelsHandler()
        );
    }

    public Hotel getHotelById(final long id) {
        return null;
    }

}
