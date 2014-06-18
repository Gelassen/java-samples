import model.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Gleichmut on 6/13/2014.
 */
public class AddMedicamentServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = checkNull(req.getParameter(Params.Medicine.NAME));
        String serial = checkNull(req.getParameter(Params.Medicine.SERIAL));
        String factory = checkNull(req.getParameter(Params.Medicine.FACTORY));

        Dao.INSTANCE.add(name, serial, factory);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private String checkNull(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

}