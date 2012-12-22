package bebao.ptittour.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import bebao.ptittour.meta.DiaDiemMeta;
import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.service.DiaDiemService;

public class CreateDiaDiemController extends Controller {
    
    private DiaDiemService ddService = new DiaDiemService();
    private DiaDiemMeta ddMeta = DiaDiemMeta.get();
    private DiaDiem dd = new DiaDiem();
    
    @Override
    public Navigation run() throws Exception {
        if (!validate()) {
            System.out.println("Check lai input");
            requestScope("error","Vui lòng nhập đầy đủ thông tin");
            return forward("/addDiaDiem");
        }
        BeanUtil.copy(new RequestMap(request), dd);
        if (ddService.findDiaDiemByName(dd.getName()) == null) {
            ddService.addDiaDiem(dd);
            System.out.println("Nhap thanh cong, redirect ve viewDiaDiem....");
//            requestScope("dd", dd.getName());
            requestScope("notice", "Cập nhật thành công địa điểm mới");
//            return forward("viewDiaDiem");
            return forward("/viewDiaDiem?dd="+dd.getName());
        } 
        else {
            System.out.println("Dia diem da ton tai, ko add duoc");
            requestScope("error","Địa điểm đã tồn tại");
            return forward("addDiaDiem");
        }
    }
    
    protected boolean validate(){
        Validators v = new Validators(request);
        v.add("name", v.required());
        v.add("moTa", v.required());
        return v.validate();
    }
}
