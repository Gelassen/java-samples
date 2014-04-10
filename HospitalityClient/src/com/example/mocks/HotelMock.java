package com.example.mocks;

import com.example.model.HotelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dkazakov
 * Date: 08.04.14
 */
public class HotelMock {

    public static List getHotelList() {
        List<HotelBean> hotels = new ArrayList<HotelBean>();
        hotels.add(generateHotel("Hilton", "UK"));
        hotels.add(generateHotel("Mandarin", "China"));
        return hotels;
    }

    private static HotelBean generateHotel(final String hotelName, final String hotelRegion) {
        HotelBean hotel = new HotelBean();
        hotel.setId(0);
        hotel.setName(hotelName);
        hotel.setRegion(hotelRegion);
        return hotel;
    }
}
