package com.example.service;


import com.example.model.InventoriesEntity;
import com.google.common.reflect.TypeToken;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.UriBuilder;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = InventoryService.class, name = "InventoryService")
public class InventoryService extends Service{

    private String hotelId;

    public List<InventoriesEntity> getInventories(final String checkin, final String checkout,
                                             final int capacity, final String hotelId) {
        this.hotelId = hotelId;
        // TODO extend params
        Type type = new TypeToken<List<InventoriesEntity>>(){}.getType();
        List<InventoriesEntity> inventories = execute(HttpMethod.GET, null, type, null);
        return inventories;
    }

    @Override
    protected UriBuilder preparePath() {
        return UriBuilder.fromUri(HOST)
                .path("rest")
                .path("inventory")
                .path(hotelId);
    }

}
