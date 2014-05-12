package com.example.service;


import com.example.model.HotelsEntity;
import com.google.common.reflect.TypeToken;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = HotelService.class, name = "HotelService")
public class HotelService extends Service{

    public List<HotelsEntity> getHotels(final String checkin, final String checkout, final int capacity,
                                 final String region) {
        // TODO extend params
        GenericType<List<HotelsEntity>> genericType = new GenericType<List<HotelsEntity>>(){};
        WebTarget target = client.target(preparePath())
                .queryParam("checkIn", checkin)
                .queryParam("checkOut", checkout)
                .queryParam("capacity", capacity);
//        String str = target.request().get();
//        List<HotelsEntity> hotels = target.request(MediaType.APPLICATION_JSON_TYPE).get(genericType);
//        FakeClass clazz = hotels.get(0);
//        List<HotelsEntity> hotels = new Mock().getHotels();

        // another attempt
        Invocation.Builder builder = client.target(preparePath())
                .queryParam("checkIn", checkin)
                .queryParam("checkOut", checkout)
                .queryParam("capacity", capacity)
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE);
        Response response = builder.buildGet().invoke();

        Type type = new TypeToken<List<HotelsEntity>>(){}.getType();
        GenericType<List<HotelsEntity>> genericTyp = new GenericType<List<HotelsEntity>>(type);
        List<HotelsEntity> list = response.readEntity(genericTyp);
        return list;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST).path("rest").path("hotels");
//        return new JerseyUriBuilder().host(URLEncoder.encode(HOST))
//                .path("Rest").path("rest").path("hotels");
    }

}
