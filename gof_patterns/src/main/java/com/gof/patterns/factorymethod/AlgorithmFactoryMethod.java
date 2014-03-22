package com.gof.patterns.factorymethod;

import com.gof.customer.algorithms.QucikAlgorithm;
import com.gof.customer.algorithms.QuickChar;
import com.gof.customer.algorithms.QuickDigit;
import com.gof.patterns.strategy.Context;
import com.gof.patterns.strategy.FirstIsIntegerStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 20.02.14
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
public class AlgorithmFactoryMethod {

    private static final int DEFAULT_RULE = 0;

    private static final int START_WITH_DIGIT_RULE = 1;

    public QucikAlgorithm createAlgorithm(String input) {
        final int rule = chooseRule(input);
        switch (rule) {
            case START_WITH_DIGIT_RULE:
                return new QuickDigit();

            default:
                return new QuickChar();

        }
    };

    private int chooseRule(final String input) {
        Context ctx = new Context();
        ctx.setStrategy(new FirstIsIntegerStrategy());
        boolean hasDigitsAsFirstChar = ctx.executeStrategy(input);
        return hasDigitsAsFirstChar ? START_WITH_DIGIT_RULE : DEFAULT_RULE;
    }



}
