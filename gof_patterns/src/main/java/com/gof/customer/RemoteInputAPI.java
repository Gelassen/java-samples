package com.gof.customer;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RemoteInputAPI {

    private static SecureRandom random = new SecureRandom();

    public String getInputAxon() {
        return new BigInteger(130, random).toString(32);
    }

    public String getInputNeuron() {
        return new BigInteger(140, random).toString(32);
    }

    public String getInputHistone() {
        return new BigInteger(150, random).toString(32);
    }

    public String getInputSynapse() {
        return new BigInteger(160, random).toString(32);
    }

}
