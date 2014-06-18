package com.example.utils.validator;

/**
 * Created by dkazakov on 14.05.2014.
 */
public class OrderError implements Error {

    private boolean checkinError;
    private boolean checkoutError;
    private boolean peopleError;
    private boolean noSimilarRooms;

    public boolean isCheckinError() {
        return checkinError;
    }

    public void setCheckinError(boolean checkinError) {
        this.checkinError = checkinError;
    }

    public boolean isCheckoutError() {
        return checkoutError;
    }

    public void setCheckoutError(boolean checkoutError) {
        this.checkoutError = checkoutError;
    }

    public boolean isPeopleError() {
        return peopleError;
    }

    public void setPeopleError(boolean peopleError) {
        this.peopleError = peopleError;
    }

    public boolean isNoSimilarRooms() {
        return noSimilarRooms;
    }

    public void setNoSimilarRooms(boolean noSimilarRooms) {
        this.noSimilarRooms = noSimilarRooms;
    }
}
