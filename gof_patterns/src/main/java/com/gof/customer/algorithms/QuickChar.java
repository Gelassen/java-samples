package com.gof.customer.algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuickChar implements QucikAlgorithm {

    /**
     * Use this algorithm if your input data includes integer in the first position
     *
     * @param data input data
     * @return count numbers
     */
    public Integer applyAlgorithm(String data){
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(data);
        int count = 0;
        while (m.find()) {
            count++;
        }
        //...some additional logic...

        return count;
    }

}
