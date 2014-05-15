package com.example.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by dkazakov on 05.05.2014.
 */
public class Session {

    private static final String CHECKIN = "checkin";
    private static final String CHECKOUT = "checkout";
    private static final String CAPACITY = "capacity";
    private static final String INVENTORY = "inventory";
    private static final String DAYS = "days";
    private static final String HOTEL = "hotel";
    private static final String REGION = "region";
    private static final String DESCRIPTION = "description";

    private HttpSession session;

    public Session(HttpServletRequest request) {
        this.session = request.getSession(false);
    }

    public void setCheckin(String checkin) {
        session.setAttribute(CHECKIN, new DateUtils().dateToSeconds(checkin));
    }

    public Long getCheckin() {
        return (Long) session.getAttribute(CHECKIN);
    }

    public void setCheckout(String checkout) {
        session.setAttribute(CHECKOUT, new DateUtils().dateToSeconds(checkout));
    }

    public Long getCheckout() {
        return (Long) session.getAttribute(CHECKOUT);
    }

    public void setDays() {
        session.setAttribute(DAYS,
                new DateUtils()
                .daysAmount(getCheckin(), getCheckout()));
    }

    public Long getDays() {
        if (getCheckin() == null || getCheckout() == null) {
            return 0l;
        }

        return new DateUtils().daysAmount(getCheckin(), getCheckout());
    }

    public void setPeopleCapacity(String people) {
        session.setAttribute(CAPACITY, Integer.valueOf(people));
    }

    public Integer getPeopleCapacity() {
        return (Integer) session.getAttribute(CAPACITY);
    }

    public void setOrder(String idInventory) {
        session.setAttribute(INVENTORY, idInventory);
    }

    public String getIdInventory() {
        return (String) session.getAttribute(INVENTORY);
    }

    public void setHotel(String hotel) {
        session.setAttribute(HOTEL, hotel);
    }

    public String getHotel() {
        return (String) session.getAttribute(HOTEL);
    }

    public void setDescription(String description) {
        session.setAttribute(DESCRIPTION, description);
    }

    public String getDescription() {
        return (String) session.getAttribute(DESCRIPTION);
    }

    public void setRegion(String region) {
        session.setAttribute(REGION, region);
    }

    public String getRegion() {
        return (String) session.getAttribute(REGION);
    }
}
