package com.gof.customer.machine;

import java.util.Date;

public class RichMachineAPI {

    /**
     * Start first
     *
     * @param location
     */
    public void init(String location) {
        System.out.println(location);
    }

    /**
     * Start second
     *
     * @param date
     */
    public void setInitTime(Date date) {
        System.out.println(date);
    }

    /**
     * Start third
     */
    public void prepare() {
        System.out.println("prepare...");
    }

    /**
     * Start fourth
     */
    public void startMachine() {
        System.out.println("start machine...");
    }

    /**
     * Start fifth
     */
    public void Execute() {
        System.out.println("execute");
    }

}

