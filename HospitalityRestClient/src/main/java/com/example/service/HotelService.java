package com.example.service;


import com.example.model.HotelPropertyEntity;
import com.example.model.HotelsEntity;
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

    public List<HotelsEntity> getHotels(final String checkin, final String checkout,
                                        final int capacity, final HotelPropertyEntity hotelProperty) {
        // TODO extend params
        DateUtils dateUtils = new DateUtils();
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("checkIn", dateUtils.dateToMillis(checkin));
        params.put("checkOut", dateUtils.dateToMillis(checkout));
        params.put("capacity", capacity);
        params.put("hasPool", hotelProperty.getHasPool());
        params.put("hasTenisCourt", hotelProperty.getHasTennisCourt());
        params.put("hasWaterslides", hotelProperty.getHasWaterslides());
        List<HotelsEntity> list = execute(HttpMethod.GET, params,
                new TypeToken<List<HotelsEntity>>(){}.getType(), null);
        return list;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST).path("rest").path("hotels");

    }

}
