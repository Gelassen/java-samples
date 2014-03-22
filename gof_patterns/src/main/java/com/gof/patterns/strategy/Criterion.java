package com.gof.patterns.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 18.02.14
 * Time: 14:10
 * To change this template use File | Settings | File Templates.
 */
public interface Criterion {

    public boolean execute(final String input);

}
