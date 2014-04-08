package com.example.restservice.storage.handlers;

import com.example.restservice.model.inventory.Hotel;
import com.example.restservice.model.reservation.RegionAsTree;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: dkazakov
 * Date: 07.04.14
 */
public class HotelsHandler implements ResultHadler {

    @Override
    public List extractEntity(ResultSet rs) throws SQLException {
        final List<Hotel> hotels = new ArrayList<Hotel>(rs.getFetchSize());
        while (rs.next()) {
            final Hotel hotel = new Hotel();
            hotel.setHotelId(rs.getLong("id"));
            hotel.setName(rs.getString("name"));
            hotel.setRegion(
                    new RegionAsTree()
                        .setCountry(rs.getString("region"))
            );
            hotels.add(hotel);
        }
        return hotels;
    }



}
