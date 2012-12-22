package bebao.ptittour.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Tour;
import bebao.ptittour.model.User;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class TimTourController extends Controller {

    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    TourService tourService = new TourService();
    
    @Override
    public Navigation run() throws Exception {
//        return null;
//        if(!validate()){
//            requestScope("error","Ban phai nhap diem Xuat phat");   
//          return forward("findTour");
//        }
          
        String diemXP = request.getParameter("diemXP");
        String diemDich = request.getParameter("diemDich");
        String ngayXP = request.getParameter("ngayXP");
        String thoiGian = request.getParameter("thoiGian");
        String gia = request.getParameter("gia");
        String cty = request.getParameter("cty");
//      if ((diemXP != null) && (diemXP != "")){
        List<Tour> tours = tourService.findTour(diemXP, diemDich, ngayXP, thoiGian, gia, cty);
        if (tours.isEmpty() || (tours == null)){
            requestScope("error", "Khong tim thay tour phu hop");
        }
        else {
            requestScope("tours", tours);
        }
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("listTours.jsp");
  }
  
  protected boolean validate() {
      Validators v = new Validators(request);
      v.add("diemXP", v.required("Phai nhap diemXP"));
      v.add("thoiGian", v.integerType("Thoi gian phai la so"));
      v.add("gia", v.floatType("Gia phai la so"));
      return v.validate();
    }
}
