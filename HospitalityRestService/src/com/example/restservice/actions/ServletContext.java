package com.example.restservice.actions;

import java.util.HashMap;
import java.util.Map;

/**
 * User: dkazakov
 * Date: 07.04.14
 */
public class ServletContext {

    private static Map<String, Action> actions = new HashMap<String, Action>();

    static {
        actions.put("hotels", new GetAllHotelsAction());
        actions.put("inventory", new GetAllInventoriesAction());
    }

    public static Action getAction(final String action) {
        return actions.get(action);
    }

}
