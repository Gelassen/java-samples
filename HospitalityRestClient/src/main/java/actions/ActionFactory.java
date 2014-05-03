package actions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ActionFactory {

    private static final Logger log = Logger.getAnonymousLogger();

    private static final Map<String, Class> map = new HashMap(5);
    
    static {
        map.put("/", WelcomeAction.class);
        map.put("/intro", IntroAction.class);
        map.put("/hotels", HotelAction.class);
        map.put("/inventory", InventoryAction.class);
        map.put("/book", BookAction.class);
    }


    public ActionFactory() {}

    public Action getAction(final String path) {
        final String name = name(path);
        Class prototype = map.get(name);
        Action action = null;
        try {
            action = (Action) prototype.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return action;
    }

    private String name(final String path) {
        final int startIdx = path.lastIndexOf("/");
        return path.substring(startIdx == -1 ? 0 : startIdx);
    }

}
