package bebao.ptittour.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import bebao.ptittour.service.UserService;

public class ViewProfileController extends Controller {
    UserService userService = new UserService();
    
    @Override
    public Navigation run() throws Exception {
        String profile = request.getParameter("profile");
        requestScope("profile", userService.findUserByUsername(profile));
        return forward("viewProfile.jsp");
    }
}
