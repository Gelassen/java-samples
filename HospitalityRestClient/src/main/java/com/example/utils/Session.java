package com.example.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by dkazakov on 05.05.2014.
 */
public class Session {

    private HttpSession session;

    public Session(HttpServletRequest request) {
        this.session = request.getSession(false);
    }

    public void setCheckin(String checkin) {
        session.setAttribute("checkin", new DateUtils().dateToMillis(checkin));
    }

    public Long getCheckin() {
        return (Long) session.getAttribute("checkin");
    }

    public void setCheckout(String checkout) {
        session.setAttribute("checkout", new DateUtils().dateToMillis(checkout));
    }

    public Long getCheckout() {
        return (Long) session.getAttribute("checkout");
    }

    public void setDays() {
        session.setAttribute("days", Mock.mockDays());
//                new DateUtils()
//                .daysAmount(getCheckin(), getCheckout()));
    }

    public Long getDays() {
        if (getCheckin() == null || getCheckout() == null) {
            return 0l;
        }

        return new DateUtils().daysAmount(getCheckin(), getCheckout());
    }

    public void setPeopleCapacity(String people) {
        session.setAttribute("capacity", Integer.valueOf(people));
    }

    public Integer getPeopleCapacity() {
        return (Integer) session.getAttribute("capacity");
    }

    public void setOrder(String idInventory) {
        session.setAttribute("id_inventory", idInventory);
    }

    public String getIdInventory() {
        return (String) session.getAttribute("id_inventory");
    }
}
