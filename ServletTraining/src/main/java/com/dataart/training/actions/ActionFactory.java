package com.dataart.training.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    private final static Logger logger = LoggerFactory.getLogger(ActionFactory.class);

    private Map map;

    public ActionFactory() {
        map = createMap();
    }

    public Action getAction(final String name) {
        Class prototype = (Class) map.get(name);
        if (prototype == null) {
            throw new RuntimeException(name + " class not maintained by " + getClass());
        }
        Action action = null;
        try {
            action = (Action) prototype.newInstance();
        } catch (InstantiationException e) {
            logger.debug("Failed to get action object", e);
        } catch (IllegalAccessException e) {
            logger.debug("Failed to get action object", e);
        }
        return action;
    }

    private Map createMap() {
        HashMap map = new HashMap();
        map.put("rssreader", MainAction.class);
        map.put("authorization", LoginAction.class);
        map.put("registration", RegistrationAction.class);
        map.put("viewpager", ViewPagerAction.class);
        map.put("addFeed", AddFeedAction.class);
        map.put("logout", LogoutAction.class);
        map.put("updateFeed", UpdateFeedAction.class);
        map.put("cache", CacheAction.class);
        map.put("deleteFeed", DeleteFeedAction.class);
        return map;
    }
}
