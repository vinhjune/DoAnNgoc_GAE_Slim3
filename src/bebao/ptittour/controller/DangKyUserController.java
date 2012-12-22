package bebao.ptittour.controller;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.Transaction;

import bebao.ptittour.model.CongTy;
import bebao.ptittour.model.Khach;
import bebao.ptittour.model.User;
import bebao.ptittour.service.UserService;

public class DangKyUserController extends Controller {
    UserService userService = new UserService();
    
    @Override
    public Navigation run() throws Exception {
        if (!validate()){
            requestScope("error", "Vui lòng điền đầy đủ thông tin");
            return forward("register.jsp");
        }
        Map<String, Object> input = new RequestMap(request);
        if (userService.findUserByUsername(requestScope("username").toString()) != null){
            requestScope("error", "Tài khoản này đã tồn tại");
            return forward("register.jsp");
        }
        else if (userService.findUserByEmail(requestScope("email").toString()) != null) {
            requestScope("error", "Email đã tồn tại");
            return forward("register.jsp");
        }
        else {
            String type = "";
            if (input.containsValue("khach")) {
                type = "khach";
                Khach newUser = new Khach();
                BeanUtil.copy(request, newUser);
                newUser.setType(type);
                userService.register(newUser);
                return forward("index");
            }
            else if (input.containsValue("congTy")) {
                type = "congTy";
                CongTy newUser = new CongTy();
                BeanUtil.copy(request, newUser);
                newUser.setType(type);
                userService.register(newUser);
                return forward("index");
            }
//            User result = userService.register((User) newUser);
            //TODO: thong bao da register thanh cong
//            if (result != null) {
//                return forward("index");
//            }
            else {
                requestScope("error", "Unknown error, try again!");
                return forward("register.jsp");
            }
        }
        
        
//        return forward("dangKyUser.jsp");
    }
    
    protected boolean validate(){
        Validators v = new Validators(request);
        v.add("type",v.required());
        v.add("username", v.required());
        v.add("password", v.required());
        v.add("hoTen", v.required());
        v.add("ngaySinh", v.required());
        v.add("email", v.required());
        v.add("phone", v.required());
        v.add("diaChi", v.required());
        return v.validate();
    }
}
