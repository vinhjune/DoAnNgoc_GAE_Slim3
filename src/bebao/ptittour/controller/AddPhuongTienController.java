package bebao.ptittour.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.PhuongTien;
import bebao.ptittour.model.User;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.PhuongTienService;
import bebao.ptittour.service.UserService;

public class AddPhuongTienController extends Controller {
    private PhuongTienService service = new PhuongTienService(); 
    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    @Override
    public Navigation run() throws Exception {
       /* PhuongTien phuongTien = new PhuongTien();
        BeanUtil.copy(new RequestMap(request), phuongTien);
        if (service.findPhuongTienByName(phuongTien.getName().toString()) == null){
            service.addPhuongTien(new RequestMap(request));
        }*/
//        System.out.println(request.getSession().getAttribute("username"));
        if (request.getSession().getAttribute("userType").equals("khach")){
            System.out.println("Ban khong co quyen truy cap chuc nang nay");
            requestScope("error", "Ban khong co quyen truy cap chuc nang nay");
            return forward("index");
        }
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("addPhuongTien.jsp");
    }
}
