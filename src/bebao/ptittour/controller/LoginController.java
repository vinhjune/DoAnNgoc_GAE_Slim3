package bebao.ptittour.controller;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import bebao.ptittour.model.User;
import bebao.ptittour.service.UserService;

public class LoginController extends Controller {
    private UserService service = new UserService();
    
    @Override
    public Navigation run() throws Exception {
        //service.login(new RequestMap(request));
        
        /*HttpSession session = request.getSession();
        
        User result = service.login(new RequestMap(request));
        
        if (result == null){
            //Worked: System.out.println("Khong tim thay user phu hop");
            //request.setAttribute("error", "Khong tim thay nguoi dung hoac sai mat khau");
            return forward("login.jsp");
        } else {
            //Worked: System.out.println("Tim thay user ...");
//            requestScope("loggedin", true);
//            requestScope("context", new Date());
//            requestScope("username", result.getUsername());
//            requestScope("userType", result.getType());
            session.setAttribute("loggedin", "true");
            session.setAttribute("username", result.getUsername());
            session.setAttribute("userType", result.getType());
            session.setAttribute("date", new Date());
            return forward(basePath);
        }*/
        
        return forward("login.jsp");
    }
}
