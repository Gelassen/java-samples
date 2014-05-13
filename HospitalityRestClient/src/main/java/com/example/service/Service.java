package com.example.service;

import com.example.json.JsonCollection;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by dkazakov on 30.04.2014.
 */
public abstract class Service {

    protected static final String HOST = "http://localhost:8080/Rest";
    protected Client client;

    public Service() {
        client = ClientBuilder.newClient();
        client.register(JsonCollection.class);
//        client.register(JsonRawProvider.class);
//        client.register(HosptialityEntityProvider.class);
    }

    protected abstract UriBuilder preparePath();

    protected <R> R execute(String method, Map<String, Object> params, Type type) {
        Response response = buildInvocation(method, params).invoke();
        Response.Status.Family statusFamily = response.getStatusInfo().getFamily();
        try {
            switch (statusFamily) {
                case SERVER_ERROR:
                case CLIENT_ERROR:
                    throw new RuntimeException("Status: " + response.getStatus());
                case SUCCESSFUL:

                    return response.readEntity(new GenericType<R>(type));

                default:
                    throw new RuntimeException("Status: " + response.getStatus());
            }
        } catch (ProcessingException e) {
            throw new RuntimeException("Unable to read response");
        }
    }

    private Invocation buildInvocation(String method, Map<String, Object> params) {
        Invocation.Builder invocationBuilder = createTarget(params)
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE);
        return invocationBuilder.build(method);
    }

    private  WebTarget createTarget (Map<String, Object> params) {
        WebTarget target = client.target(preparePath());
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                target = target.queryParam(entry.getKey(), entry.getValue());
            }
        }
        return target;
    }
}
