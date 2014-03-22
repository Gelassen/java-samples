package com.gof.patterns.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 19.02.14
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class Context {

    private Criterion strategy;

    public void setStrategy(Criterion strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Did you define a strategy?");
        }
        return strategy.execute(input);
    }
}
