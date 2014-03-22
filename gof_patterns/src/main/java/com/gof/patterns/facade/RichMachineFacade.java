package com.gof.patterns.facade;

import com.gof.customer.machine.RichMachineAPI;
import com.gof.customer.monitors.MonitorUK;
import com.gof.customer.monitors.MonitorUS;
import com.gof.patterns.observer.MonitorObserver;

import java.util.Date;
import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 20.02.14
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class RichMachineFacade extends Observable {

    public RichMachineFacade() {
        addObserver(new MonitorObserver(new MonitorUK()));
        addObserver(new MonitorObserver(new MonitorUS()));

    }

    public void start(final String location, final Date date) {
        RichMachineAPI richMachine = new RichMachineAPI();
        richMachine.init(location);
        richMachine.setInitTime(date);
        richMachine.prepare();
        richMachine.startMachine();
        richMachine.Execute();;

        setChanged();
        notifyObservers(location);
    }

}
