package service;

import model.Hotel;
import org.glassfish.jersey.uri.internal.JerseyUriBuilder;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = HotelService.class, name = "HotelService")
public class HotelService extends Service{

    public List<Hotel> getHotels(final String checkin, final String checkout, final int capacity,
                                 final String region) {
        // TODO extend params
        GenericType<List<Hotel>> genericType = new GenericType<List<Hotel>>(){};
        WebTarget target = client.target(preparePath())
                .queryParam("startDate", checkin)
                .queryParam("startDate", checkout);
        List<Hotel> hotels = target.request(MediaType.APPLICATION_JSON_TYPE).get(genericType);
        return hotels;
    }

    @Override
    protected UriBuilder preparePath() {
        return new JerseyUriBuilder().host(HOST)
                .path("Rest").path("rest").path("hotels");
    }

}
