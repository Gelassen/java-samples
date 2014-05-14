package com.example.utils.validator;

import java.util.regex.Pattern;

/**
 * Created by Gleichmut on 5/2/2014.
 */
public class Validator {

    public boolean validDate(String date) {
        Pattern pattern = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        return pattern.matcher(date).matches();
    }

    public boolean validNumber(String number) {
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(number).matches();
    }

}
