package com.example.utils.validator;

/**
 * Created by dkazakov on 15.05.2014.
 */
public class BookingError implements Error {

    private boolean nameError;
    private boolean phoneError;

    public boolean isNameError() {
        return nameError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }

    public boolean isPhoneError() {
        return phoneError;
    }

    public void setPhoneError(boolean phoneError) {
        this.phoneError = phoneError;
    }
}
