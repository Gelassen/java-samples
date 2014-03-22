package com.dataart.training.comparators;

import com.dataart.training.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 30.10.12
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public class NewestFirst implements Comparator<Feed> {

    private final static Logger logger = LoggerFactory.getLogger(NewestFirst.class);

    private final static String STRING_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss z";

    @Override
    public int compare(Feed o1, Feed o2) {
        String str1Date = o1.getPubDate();
        String str2Date = o2.getPubDate();

        //SimpleDateFormat format = new SimpleDateFormat(STRING_DATE_FORMAT, Locale.US);
        try {
        /*    Date date1 = new Date(Long.valueOf(str1Date));//format.parse(str1Date);
            Date date2 = new Date(Long.valueOf(str2Date));//format.parse(str2Date);*/
            //return  date1.compareTo(date2) > 0 ? -1 : 1;
        } catch (Exception e) {
            logger.error("Failed to create date", e);
        }
        return Long.valueOf(str1Date) > Long.valueOf(str2Date) ? -1 : 1;
    }

    public static boolean firstIsNewer(final String str1Date, final String str2Date) {
        boolean result = false;
        SimpleDateFormat format = new SimpleDateFormat(STRING_DATE_FORMAT, Locale.US);
        try {
            Date date1 = format.parse(str1Date);
            Date date2 = format.parse(str2Date);
            int resultAsInt = date1.compareTo(date2);
            result = resultAsInt > 0 ? true : false;
        } catch (Exception e) {
            logger.error("Failed to create date", e);
        }
        return result;
    }

}

