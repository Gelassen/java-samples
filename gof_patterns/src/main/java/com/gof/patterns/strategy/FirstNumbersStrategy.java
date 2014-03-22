package com.gof.patterns.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 18.02.14
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
public class FirstNumbersStrategy implements Criterion {

    /**
    *
    * @return true if first 5 chars are integers
    * */
    @Override
    public boolean execute(final String input) {
        boolean hasNumbers = false;


        final int firstIdx = 0;
        final int lastIdx = 5;
        String str = extractRelevantData(input, firstIdx, lastIdx);
        final int size = str.length();
        for (int i = 0; i < size; i++) {
            if (isDigit(str.charAt(i))) {
                hasNumbers = true;
                break;
            }
        }
        return hasNumbers;
    }

    protected String extractRelevantData(String input, int firstIdx, int lastIdx) {
        String result = input.substring(firstIdx, lastIdx);
        return result.replaceAll("\\D+", "");
    }

    //TODO clarify requirements - does we support only 10 radix?
    protected boolean isDigit(char ch) {
        final int failed = -1;
        return Character.digit(ch, 10) != failed;
    }
}
