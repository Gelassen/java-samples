package com.gof.patterns.chain.processors;

import com.gof.patterns.chain.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 18.02.14
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */
public abstract class CriterionProcessor {

    protected Bundle result;
    private CriterionProcessor next;

    private CriterionProcessor() {
        this(null, null);
    }

    public CriterionProcessor(Bundle result) {
        this(null, result);
    }

    public CriterionProcessor(CriterionProcessor processor, Bundle result) {
        this.next = processor;
        this.result = result;
    }

    public Bundle getResult() {
        return result;
    }

    public void processInput(final String input) {
        handleData(input);
        if (next != null) {
            next.processInput(input);
        }
    }

    protected abstract void handleData(final String input);
}
