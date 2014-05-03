package service;

import model.Hotel;
import model.HotelsEntity;
import org.glassfish.jersey.uri.internal.JerseyUriBuilder;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = HotelService.class, name = "HotelService")
public class HotelService extends Service {

    public List<HotelsEntity> getHotels(final String checkin, final String checkout, final int capacity,
                                 final String region) {
        // TODO extend params
        GenericType<List<HotelsEntity>> genericType = new GenericType<List<HotelsEntity>>(){};
        WebTarget target = client.target(preparePath());
//                .queryParam("startDate", checkin)
//                .queryParam("startDate", checkout);
        List<HotelsEntity> hotels = target.request(MediaType.APPLICATION_JSON_TYPE).get(genericType);
        return hotels;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST).path("rest").path("hotels");
//        return new JerseyUriBuilder().host(URLEncoder.encode(HOST))
//                .path("Rest").path("rest").path("hotels");
    }

}
