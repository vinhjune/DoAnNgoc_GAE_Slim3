package bebao.ptittour.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;


import bebao.ptittour.model.CongTy;
import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Tour;
import bebao.ptittour.model.User;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class FindTourController extends Controller {
    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    TourService tourService = new TourService();
    
    @Override
    public Navigation run() throws Exception {
/*//        if(!validate()){
//            return forward("findTour");
//        }
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        
        String diemXP = requestScope("diemXP");
        String diemDich = requestScope("diemDich");
        String ngayXP = requestScope("ngayXP");
        String thoiGian = requestScope("thoiGian");
        String gia = requestScope("gia");
        String cty = requestScope("cty");
        if ((diemXP != null) && (diemXP != "")){
            List<Tour> tours = tourService.findTour(diemXP, diemDich, ngayXP, thoiGian, gia,cty);
            requestScope("tours", tours);
            return forward("listTours.jsp");
        }
//        requestScope("errorDiemXP","Ban phai nhap diem Xuat phat");
        return forward("findTour.jsp");
    }
    
    protected boolean validate() {
        Validators v = new Validators(request);
        v.add("diemXP", v.required("Phai nhap diemXP"));
        v.add("thoiGian", v.integerType("Thoi gian phai la so"));
        v.add("gia", v.floatType("Gia phai la so"));
        return v.validate();*/
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("findTour.jsp");
    }
}
