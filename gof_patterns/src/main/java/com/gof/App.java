package com.gof;

import com.gof.customer.algorithms.QucikAlgorithm;
import com.gof.patterns.adapter.RemoteApiAdapter;
import com.gof.patterns.facade.RichMachineFacade;
import com.gof.patterns.factorymethod.AlgorithmFactoryMethod;
import com.gof.patterns.singletone.AccessToApi;
import com.gof.patterns.strategy.Context;
import com.gof.patterns.strategy.FirstNumbersStrategy;

import java.util.Date;

public class App {


    public static void main(String[] args) {
        String input = new RemoteApiAdapter().getInput();

        AlgorithmFactoryMethod algorithmChooser = new AlgorithmFactoryMethod();
        QucikAlgorithm algorithm = algorithmChooser.createAlgorithm(input);
        final int result = algorithm.applyAlgorithm(input);
        input.concat(String.valueOf(result));

        Context ctx = new Context();
        ctx.setStrategy(new FirstNumbersStrategy());
        final int length = input.length();

        AccessToApi.getInstance()
                .getOutputAPI()
                .setOutputData(length, ctx.executeStrategy(input));

        new RichMachineFacade()
                .start("location", new Date(System.currentTimeMillis()));
    }
}
