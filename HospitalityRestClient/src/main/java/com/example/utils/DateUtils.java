package com.example.utils;


import java.util.Calendar;

/**
 * Created by dkazakov on 05.05.2014.
 */
public class DateUtils {

    private static final long DAY_IN_MILLIS = 24 * 60 * 60 * 1000;

    private static final int DAY_IDX = 0;
    private static final int MONTH_IDX = 1;
    private static final int YEAR_IDX = 2;

    private static final int DEFAULT_HOURS = 0;
    private static final int DEFAULT_MINUTES = 0;
    private static final int DEFAULT_SECONDS = 0;


    public long dateToSeconds(String date) {
        String[] tokens = date.split("/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                Integer.valueOf(tokens[YEAR_IDX]),
                Integer.valueOf(tokens[MONTH_IDX]),
                Integer.valueOf(tokens[DAY_IDX]),
                DEFAULT_HOURS,
                DEFAULT_MINUTES,
                DEFAULT_SECONDS);
        return calendar.getTimeInMillis() / 1000;
    }

    public long daysAmount(long checkin, long checkout) {
        final long diff = checkout - checkin;
        long days = diff / DAY_IN_MILLIS;
        long hours = diff % DAY_IN_MILLIS;
        return hours != 0 ? ++days : days;
    }

}
