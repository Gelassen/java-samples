package com.gof.customer.monitors;

public class MonitorUK implements Monitor {

    @Override
    public void showRichMessage(String msg) {
        System.out.println("UK " + msg);
    }
}
