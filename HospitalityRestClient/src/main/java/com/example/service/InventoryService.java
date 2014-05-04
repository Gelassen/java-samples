package com.example.service;


import com.example.model.InventoriesEntity;
import com.example.utils.Mock;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = InventoryService.class, name = "InventoryService")
public class InventoryService extends Service{

    public List<InventoriesEntity> getInventories(final String checkin, final String checkout,
                                             final int capacity, final String hotelId) {
        // TODO extend params
        GenericType<List<InventoriesEntity>> genericType = new GenericType<List<InventoriesEntity>>(){};
        WebTarget target = client.target(preparePath());
//                .queryParam("startDate", checkin)
//                .queryParam("startDate", checkout);
//        List<HotelsEntity> hotels = target.request(MediaType.APPLICATION_JSON_TYPE).get(genericType);

        List<InventoriesEntity> inventories = new Mock().getInventories();

        return inventories;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST).path("rest").path("inventory");
//        return new JerseyUriBuilder().host(URLEncoder.encode(HOST))
//                .path("Rest").path("rest").path("hotels");
    }

}
