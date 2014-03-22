package com.gof.patterns.chain.processors;

import com.gof.patterns.chain.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 18.02.14
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class OneMoreProcessor extends CriterionProcessor {

    public OneMoreProcessor(Bundle result) {
        super(result);
    }

    public OneMoreProcessor(CriterionProcessor processor, Bundle result) {
        super(processor, result);
    }

    @Override
    protected void handleData(String input) {
        System.out.println("Handle data into " + this.getClass().getSimpleName());
    }
}
