package bebao.ptittour.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import bebao.ptittour.model.PhuongTien;
import bebao.ptittour.service.PhuongTienService;

public class CreatePhuongTienController extends Controller {
    PhuongTienService ptService = new PhuongTienService();
    
    @Override
    public Navigation run() throws Exception {
        
        if (!validate()){
            requestScope("error", "Vui long nhap day du thong tin");
            return forward("addPhuongTien.jsp");
        }
        
        PhuongTien phuongTien = new PhuongTien();
        BeanUtil.copy(new RequestMap(request), phuongTien);
        if (ptService.findPhuongTienByName(phuongTien.getName()) == null){
            ptService.addPhuongTien(new RequestMap(request));
            return forward("index");
        }
        else {
            requestScope("error", "Phuong tien nay da ton tai");
            return forward("addPhuongTien.jsp");
        }
    }
    
    protected boolean validate(){
        Validators v = new Validators(request);
        v.add("name", v.required());
        return v.validate();
    }
}
