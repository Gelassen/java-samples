package com.example.service;


import com.example.model.InventoriesEntity;
import com.google.common.reflect.TypeToken;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.UriBuilder;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dkazakov on 29.04.2014.
 */
@Stateless
@EJB(beanInterface = InventoryService.class, name = "InventoryService")
public class InventoryService extends Service{

    private String hotelId;

    public List<InventoriesEntity> getInventories(final String checkin, final String checkout, final String hotelId) {
        this.hotelId = hotelId;
        Map<String, Object> params = new HashMap<String, Object>(2);
        params.put("checkIn", checkin);
        params.put("checkOut", checkout);

        Type type = new TypeToken<List<InventoriesEntity>>(){}.getType();
        List<InventoriesEntity> inventories = execute(HttpMethod.GET, params, type, null);
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
