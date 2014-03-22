package com.gof.customer.monitors;

public class MonitorUS implements Monitor {

    @Override
    public void showRichMessage(String msg) {
        System.out.println("US " + msg);
    }
}

