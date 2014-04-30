package actions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ActionFactory {

    private static final Logger log = Logger.getAnonymousLogger();

    private static final Map map = new HashMap(3);
    
    static {
        map.put("intro", IntroAction.class);
        map.put("hotels", HotelAction.class);
        map.put("inventory", InventoryAction.class);
        map.put("book", BookAction.class);
    }


    public ActionFactory() {}

    public Action getAction(final String path) {
        final String name = name(path);
        return (Action) map.get(name);
    }

    private String name(final String path) {
        final int startIdx = path.lastIndexOf("/");
        return path.substring(startIdx);
    }

}
