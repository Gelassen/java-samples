package actions;

import service.HotelService;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dkazakov on 30.04.2014.
 */
public class IntroAction implements Action {

    @EJB
    private HotelService hotelService;

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) {
        // get params, validate them and send request to hotels

    }
}
