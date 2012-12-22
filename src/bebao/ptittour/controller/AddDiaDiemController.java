package bebao.ptittour.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.User;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class AddDiaDiemController extends Controller {
    UserService userService = new UserService();
    TourService tourService = new TourService();
    DiaDiemService ddService = new DiaDiemService();

    
    @Override
    public Navigation run() throws Exception {
        if (request.getSession().getAttribute("userType").equals("khach")){
            System.out.println("Ban khong co quyen truy cap chuc nang nay");
            requestScope("error", "Ban khong co quyen truy cap chuc nang nay");
            return forward("index");
        }
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("addDiaDiem.jsp");
    }
}
