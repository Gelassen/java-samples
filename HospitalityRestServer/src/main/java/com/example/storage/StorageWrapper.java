package com.example.storage;


import com.example.model.inventory.Hotel;
import com.example.storage.handlers.HotelsHandler;

import java.util.Collection;

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
