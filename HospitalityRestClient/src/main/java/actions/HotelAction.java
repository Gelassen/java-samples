package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class HotelAction implements Action {

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        // get hotel list based on check in, check out, region, capacity, amenities
        return null;
    }
}
