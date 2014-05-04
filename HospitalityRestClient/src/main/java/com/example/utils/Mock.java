package com.example.utils;

import com.example.model.HotelsEntity;
import com.example.model.InventoriesEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gleichmut on 5/3/2014.
 */
public class Mock {

    public List<HotelsEntity> getHotels() {
        HotelsEntity hilton = new HotelsEntity();
        hilton.setIdHotel(0);
        hilton.setName("Hilton");
        hilton.setDescription("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..");
        hilton.setRegion("UK");

        HotelsEntity mandarin = new HotelsEntity();
        mandarin.setIdHotel(1);
        mandarin.setName("Mandarin");
        mandarin.setDescription("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..");
        mandarin.setRegion("China");

        List<HotelsEntity> list = new ArrayList<HotelsEntity>();
        list.add(hilton);
        list.add(mandarin);
        return list;
    }

    public List<InventoriesEntity> getInventories() {
        return null;
    }
}
