import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import model.*;
import model.Error;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Gleichmut on 6/13/2014.
 */
public class MainServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = checkNull(req.getParameter(Params.Medicine.NAME));
        String serial = checkNull(req.getParameter(Params.Medicine.SERIAL));
        String factory = checkNull(req.getParameter(Params.Medicine.FACTORY));

        final String path = req.getRequestURI();

        Medicine medicine = new Medicine(name, serial, factory);
        List<Medicine> medicineList = Dao.INSTANCE.getBy(medicine);

        model.Error error = new Error();
        error.setExists(!medicineList.isEmpty());

        req.setAttribute("medicine", medicine);
        req.setAttribute("error", error);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private String checkNull(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

}