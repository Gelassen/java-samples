package com.example.service;


import com.example.model.HotelPropertyEntity;
import com.example.model.HotelsResponse;
import com.example.model.ReservationDatesEntity;
import com.example.utils.DateUtils;
import com.google.common.reflect.TypeToken;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.UriBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = HotelService.class, name = "HotelService")
public class HotelService extends Service{

    public List<HotelsResponse> getHotels(final String checkin, final String checkout,
                                        final int capacity, final HotelPropertyEntity hotelProperty) {
        // TODO extend params
        DateUtils dateUtils = new DateUtils();
        Map<String, Object> params = new HashMap<String, Object>(6);
        params.put("checkIn", dateUtils.dateToSeconds(checkin));
        params.put("checkOut", dateUtils.dateToSeconds(checkout));
        params.put("capacity", capacity);
        params.put("hasPool", hotelProperty.getHasPool());
        params.put("hasTenisCourt", hotelProperty.getHasTennisCourt());
        params.put("hasWaterslides", hotelProperty.getHasWaterslides());
        List<HotelsResponse> list = execute(HttpMethod.GET, params,
                new TypeToken<List<HotelsResponse>>(){}.getType(), null);
        postProcessData(list);
        return list;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST).path("rest").path("hotels");

    }

    private void postProcessData(List<HotelsResponse> list ) {
        for (HotelsResponse hotel : list) {
            for (ReservationDatesEntity dates : hotel.getReservationDates()) {
                dates.prepareToView();
            }
        }
    }

}
