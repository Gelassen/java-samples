package com.gof.patterns.adapter;

import com.gof.customer.RemoteInputAPI;

/**
 * Created with IntelliJ IDEA.
 * User: dkazakov
 * Date: 19.02.14
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public class RemoteApiAdapter implements UnifiedRemoteInputApi {

    private RemoteInputAPI remoteInputAPI = new RemoteInputAPI();

    @Override
    public String getInput() {
        return adaptApiRequest();
    }

    private String adaptApiRequest() {
        StringBuilder builder = new StringBuilder();
        builder.append(remoteInputAPI.getInputAxon());
        builder.append(remoteInputAPI.getInputHistone());
        builder.append(remoteInputAPI.getInputNeuron());
        builder.append(remoteInputAPI.getInputSynapse());
        return builder.toString();
    }
}
