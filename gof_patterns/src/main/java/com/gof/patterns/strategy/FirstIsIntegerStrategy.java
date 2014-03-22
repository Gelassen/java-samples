package com.gof.patterns.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 20.02.14
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class FirstIsIntegerStrategy extends FirstNumbersStrategy {

    @Override
    public boolean execute(String input) {
        return isDigit(input.charAt(0));
    }
}
