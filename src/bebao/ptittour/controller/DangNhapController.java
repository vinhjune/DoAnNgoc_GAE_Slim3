package bebao.ptittour.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import bebao.ptittour.model.User;
import bebao.ptittour.service.UserService;

public class DangNhapController extends Controller {
    UserService userService = new UserService();
    
    @Override
    public Navigation run() throws Exception {
        if (!validate()){
            requestScope("error", "Vui lòng nhập đầy đủ thông tin");
            return forward("login.jsp");
        }
        
        HttpSession session = request.getSession();
        
        User result = userService.login(new RequestMap(request));
        
        if (result == null){
            //Worked: System.out.println("Khong tim thay user phu hop");
            requestScope("error", "Không tìm thấy tài khoản hoặc sai mật khẩu");
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
            System.out.println("userType : = " + result.getType());
            session.setAttribute("date", new Date());
            return forward("/index");
        }
    }
    
    protected boolean validate(){
        Validators v = new Validators(request);
        v.add("username", v.required());
        v.add("password", v.required());
        return v.validate();
    }
}
