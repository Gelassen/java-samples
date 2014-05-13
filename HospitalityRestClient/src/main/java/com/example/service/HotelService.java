package com.example.service;


import com.example.model.HotelsEntity;
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

    public List<HotelsEntity> getHotels(final String checkin, final String checkout, final int capacity,
                                 final String region) {
        // TODO extend params
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("checkIn", checkin);
        params.put("checkOut", checkout);
        params.put("capacity", capacity);
        List<HotelsEntity> list = execute(HttpMethod.GET, params, new TypeToken<List<HotelsEntity>>(){}.getType());
        return list;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST).path("rest").path("hotels");

    }

}
