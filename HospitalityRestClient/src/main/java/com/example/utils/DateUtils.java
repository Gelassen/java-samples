package com.example.utils;


/**
 * Created by dkazakov on 05.05.2014.
 */
public class DateUtils {

    private static final long DAY_IN_MILLIS = 24 * 60 * 60 * 1000;

    public long dateToMillis(String date) {
        //TODO complete me
        return 0;
    }

    public long daysAmount(long checkin, long checkout) {
        final long diff = checkout - checkin;
        long days = diff / DAY_IN_MILLIS;
        long hours = diff % DAY_IN_MILLIS;
        return hours != 0 ? ++days : days;
    }

}
