package com.gof.customer;

public class RemoteOutputAPI {

    public void setOutputData(int res, boolean digital) {
        System.out.println("Sent " + res +"digital = " + digital + " ok...");
    }
}
