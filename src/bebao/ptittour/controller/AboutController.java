package bebao.ptittour.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.User;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.UserService;

public class AboutController extends Controller {
    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    @Override
    public Navigation run() throws Exception {
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("about.jsp");
    }
}
