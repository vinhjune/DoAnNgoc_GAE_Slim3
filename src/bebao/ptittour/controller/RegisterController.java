package bebao.ptittour.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import bebao.ptittour.service.UserService;

public class RegisterController extends Controller {

//    private UserService service = new UserService();
    
    @Override
    public Navigation run() throws Exception {
        // cac thao tac xu ly logic o day
        // neu can lam viec voi CSDL thi goi den cac service tuong ung
//        service.register(new RequestMap(request));
        return forward("register.jsp");
        
        /*
        if (request != null) {
            User newUser = new User(
                request.getAttribute("username").toString(),
                request.getAttribute("password").toString(),
                request.getAttribute("hoTen").toString(),
                (Date)request.getAttribute("ngaySinh"),
                (Email)request.getAttribute("email"),
                request.getAttribute("phone").toString(),
                request.getAttribute("diaChi").toString(), 
                request.getAttribute("type").toString());
            service.Register(newUser);
        }
        */

    }
}
