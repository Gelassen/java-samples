package com.dataart.training.comparators;

import com.dataart.training.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class OldestFirst implements Comparator<Feed> {

    private final static Logger logger = LoggerFactory.getLogger(NewestFirst.class);

    private final static String stringDateFormat = "EEE, dd MMM yyyy HH:mm:ss z";

    @Override
    public int compare(Feed o1, Feed o2) {
        String str1Date = o1.getPubDate();
        String str2Date = o2.getPubDate();

/*        SimpleDateFormat format = new SimpleDateFormat(stringDateFormat, Locale.US);
        try {
            Date date1 = format.parse(str1Date);
            Date date2 = format.parse(str2Date);
            return  date1.compareTo(date2);
        } catch (ParseException e) {
            logger.error("Failed to create date", e);
        }*/


        return Long.valueOf(str1Date) > Long.valueOf(str2Date) ? 1 : -1;
    }
}
