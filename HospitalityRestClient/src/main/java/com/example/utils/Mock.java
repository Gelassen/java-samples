package com.example.utils;

import com.example.model.*;

import java.math.BigDecimal;
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
        List<InventoriesEntity> list = new ArrayList<InventoriesEntity>(2);

        InventoriesEntity oneTypeOfInventory = new InventoriesEntity();
        oneTypeOfInventory.setIdInventory(0);
        oneTypeOfInventory.setPrice(new BigDecimal(100.30));

        // set ammenities
        AmmenitiesEntity oneTypeOfInventoryAmmenities = new AmmenitiesEntity();
        oneTypeOfInventoryAmmenities.setHasBreakfast(false);
        oneTypeOfInventory.setAmmenities(oneTypeOfInventoryAmmenities);

        RoomEntity oneTypeOfInventoryRoom = new RoomEntity();
        oneTypeOfInventoryRoom.setBooked(false);
        oneTypeOfInventoryRoom.setIdRoom(0);
        oneTypeOfInventoryRoom.setLocked(false);
        oneTypeOfInventoryRoom.setPeopleCapacity(1);
        oneTypeOfInventoryRoom.setRoomType("SINGLE");

        RoomPropertyEntity oneTypeOfInventoryRoomProperty = new RoomPropertyEntity();
        oneTypeOfInventoryRoomProperty.setHasBalcony(true);
        oneTypeOfInventoryRoomProperty.setHasConditioner(false);
        oneTypeOfInventoryRoomProperty.setHasTv(false);
        oneTypeOfInventoryRoomProperty.setNiceViewOnPool(false);
        oneTypeOfInventoryRoomProperty.setNiceViewOnSea(false);
        oneTypeOfInventoryRoomProperty.setUglyViewFromWindow(true);
        oneTypeOfInventoryRoomProperty.setIdRoomProperty(0);

        oneTypeOfInventoryRoom.setRoom(oneTypeOfInventoryRoomProperty);

        HotelsEntity hotel = new HotelsEntity();
        hotel.setIdHotel(99);
        hotel.setName("mock hotel name");
        hotel.setDescription("mock hotel description");
        hotel.setRegion("mock region");
        oneTypeOfInventoryRoom.setHotel(hotel);

        // set room
        oneTypeOfInventory.setRoom(oneTypeOfInventoryRoom);

        InventoriesEntity anotherTypeOfInventory = new InventoriesEntity();
        anotherTypeOfInventory.setIdInventory(1);
        anotherTypeOfInventory.setPrice(new BigDecimal(300.30));

        // set ammenities
        AmmenitiesEntity anotherTypeOfInventoryAmmenities = new AmmenitiesEntity();
        anotherTypeOfInventoryAmmenities.setHasBreakfast(true);
        anotherTypeOfInventory.setAmmenities(anotherTypeOfInventoryAmmenities);

        RoomEntity anotherTypeOfInventoryRoom = new RoomEntity();
        anotherTypeOfInventoryRoom.setBooked(false);
        anotherTypeOfInventoryRoom.setIdRoom(1);
        anotherTypeOfInventoryRoom.setLocked(false);
        anotherTypeOfInventoryRoom.setPeopleCapacity(2);
        anotherTypeOfInventoryRoom.setRoomType("TWIN");

        RoomPropertyEntity anotherTypeOfInventoryRoomProperty = new RoomPropertyEntity();
        anotherTypeOfInventoryRoomProperty.setHasBalcony(false);
        anotherTypeOfInventoryRoomProperty.setHasConditioner(false);
        anotherTypeOfInventoryRoomProperty.setHasTv(false);
        anotherTypeOfInventoryRoomProperty.setNiceViewOnPool(false);
        anotherTypeOfInventoryRoomProperty.setNiceViewOnSea(false);
        anotherTypeOfInventoryRoomProperty.setUglyViewFromWindow(true);
        anotherTypeOfInventoryRoomProperty.setIdRoomProperty(1);

        anotherTypeOfInventoryRoom.setRoom(anotherTypeOfInventoryRoomProperty);

        // set room
        anotherTypeOfInventory.setRoom(anotherTypeOfInventoryRoom);

        list.add(oneTypeOfInventory);
        list.add(anotherTypeOfInventory);
        return list;
    }

    public static int mockDays() {
        return 2/*139936*/;
    }
}
