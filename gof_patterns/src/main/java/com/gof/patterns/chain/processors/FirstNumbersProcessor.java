package com.gof.patterns.chain.processors;

import com.gof.patterns.chain.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 18.02.14
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */
public class FirstNumbersProcessor extends CriterionProcessor {

    public FirstNumbersProcessor(Bundle result) {
        super(result);
    }

    public FirstNumbersProcessor(CriterionProcessor processor, Bundle result) {
        super(processor, result);
    }

    @Override
    protected void handleData(String input) {
        boolean hasNumbers = false;

        String str = extractRelevantData(input);
        final int size = str.length();
        for (int i = 0; i < size; i++) {
            if (isDigit(str.charAt(i))) {
                hasNumbers = true;
                break;
            }
        }

        if (result != null) {
            result.setHasDigits(hasNumbers);
        }
    }

    private String extractRelevantData(String input) {
        final int firstIdx = 0;
        final int lastIdx = 5;
        String result = input.substring(firstIdx, lastIdx);
        return result.replaceAll("\\D+", "");
    }

    //TODO clarify requirements - does we support only 10 radix?
    private boolean isDigit(char ch) {
        final int failed = -1;
        return Character.digit(ch, 10) != failed;
    }
}
