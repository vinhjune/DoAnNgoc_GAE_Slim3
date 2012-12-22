package bebao.ptittour.controller;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class LogoutController extends Controller {

    @Override
    public Navigation run() throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("loggedin", "");
        session.setAttribute("username", "");
        session.setAttribute("userType", "");
        session.setAttribute("date","");
        return forward("index");
    }
}
