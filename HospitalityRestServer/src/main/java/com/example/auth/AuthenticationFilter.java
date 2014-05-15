package com.example.auth;

import com.example.service.UserService;

import javax.annotation.Priority;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by dkazakov on 14.05.2014.
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    private UserService userService;

    public AuthenticationFilter() throws NamingException {
        InitialContext initialContext = new InitialContext();
        this.userService = (UserService) initialContext.lookup("java:comp/env/UserService");
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
/*        String auth = containerRequestContext.getHeaders().getFirst("authorization");
        if (auth == null) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        final String decodeAuth = new String(Base64.decodeBase64(auth));//Base64.decodeAsString(auth);
        final int pos = decodeAuth.indexOf(":");

        String login = decodeAuth.substring(0, pos);
        String password = decodeAuth.substring(pos+1);
        final boolean isAuth = userService.authenticate(login, password);
        if (!isAuth) {
            containerRequestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .build()
            );
        }*/

    }


}
