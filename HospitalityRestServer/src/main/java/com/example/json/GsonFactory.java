package com.example.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;

/**
 * Created by Gleichmut on 5/18/2014.
 */
public class GsonFactory {

    private static Gson gson = createGsonBuilder().create();

    public static Gson createGson() {
        return gson;
    }


    private static GsonBuilder createGsonBuilder() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .registerTypeAdapterFactory(new NullableWrapperAdapterFactory());
    }

}
