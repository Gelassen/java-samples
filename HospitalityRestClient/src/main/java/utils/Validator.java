package utils;

import java.util.regex.Pattern;

/**
 * Created by Gleichmut on 5/2/2014.
 */
public class Validator {

    public boolean validDate(String date) {
        Pattern pattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)");
        return pattern.matcher(date).matches();
    }

    public boolean validNumber(String number) {
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(number).matches();
    }

}
