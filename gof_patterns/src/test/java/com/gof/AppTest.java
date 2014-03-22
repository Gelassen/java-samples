package com.gof;

import com.gof.customer.algorithms.QucikAlgorithm;
import com.gof.patterns.adapter.RemoteApiAdapter;
import com.gof.patterns.chain.Bundle;
import com.gof.patterns.chain.processors.CriterionProcessor;
import com.gof.patterns.chain.processors.FirstNumbersProcessor;
import com.gof.patterns.chain.processors.OneMoreProcessor;
import com.gof.patterns.facade.RichMachineFacade;
import com.gof.patterns.factorymethod.AlgorithmFactoryMethod;
import com.gof.patterns.singletone.AccessToApi;
import com.gof.patterns.strategy.Context;
import com.gof.patterns.strategy.Criterion;
import com.gof.patterns.strategy.FirstNumbersStrategy;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


public class AppTest{


    @Test
    public void testApp() {
        final AccessToApi instanceOne = AccessToApi.getInstance();
        final AccessToApi instanceTwo = AccessToApi.getInstance();

        assertEquals("Two instance of singletone: ", instanceOne, instanceTwo);
    }

    @Test
    public void testStrategy() {

        String inputWithNumbers = "123Asd";
        String inputWithoutNumbers = "hello world";
        Context ctx = new Context();
        ctx.setStrategy(new FirstNumbersStrategy());

        boolean result = ctx.executeStrategy(inputWithNumbers);
        assertEquals("Test str with numbers ", result, true);

        result = ctx.executeStrategy(inputWithoutNumbers);
        assertEquals("Test str with numbers ", result, false);
    }

    @Test
    public void testChainOfResponsibility() {

        String inputWithNumbers = "123Asd";

        CriterionProcessor processor = new FirstNumbersProcessor(null, new Bundle());
        processor.processInput(inputWithNumbers);
        assertEquals("Chain test with one filter", processor.getResult().isHasDigits(), true);

        Bundle bundle = new Bundle();
        processor = new OneMoreProcessor(new FirstNumbersProcessor(bundle), bundle);
        processor.processInput(inputWithNumbers);
        assertEquals("Chain test with two filter", processor.getResult().isHasDigits(), true);
    }

    @Test
    public void testAdapter() {
        Context ctx = new Context();
        ctx.setStrategy(new FirstNumbersStrategy());

        String input = new RemoteApiAdapter().getInput();
        boolean result = ctx.executeStrategy(input);
        System.out.println(input);

        assertEquals("Adapter test", result, true);
    }

    @Test
    public void testFactoryMethod() {
        String inputWithNumbers = "123Asd";
        String inputWithoutNumbers = "hello";

        AlgorithmFactoryMethod algorithmChooser = new AlgorithmFactoryMethod();
        QucikAlgorithm algorithm = algorithmChooser.createAlgorithm(inputWithNumbers);
        int result = algorithm.applyAlgorithm(inputWithNumbers);
        assertEquals("Factory method test", result, 3);

        algorithm = algorithmChooser.createAlgorithm(inputWithoutNumbers);
        result = algorithm.applyAlgorithm(inputWithoutNumbers);
        assertEquals("Factory method test", result, 5);
    }

    @Test
    public void testFacade() {
        new RichMachineFacade().start("location", new Date());

    }
}
