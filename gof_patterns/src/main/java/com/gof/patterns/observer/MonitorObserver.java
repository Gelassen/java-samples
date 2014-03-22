package com.gof.patterns.observer;

import com.gof.customer.monitors.Monitor;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 21.02.14
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
public class MonitorObserver implements Observer {

    private Monitor monitor;

    public MonitorObserver(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void update(Observable o, Object arg) {
        monitor.showRichMessage((String) arg);
    }
}
