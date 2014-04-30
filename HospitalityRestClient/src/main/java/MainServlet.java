import actions.Action;
import actions.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        processResponse(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        processResponse(req, resp);
    }

    private void processResponse(HttpServletRequest req, HttpServletResponse resp) {
        final String path = req.getServletPath();
        Action action = new ActionFactory().getAction(path);
        action.perform(req, resp);
    }
}
