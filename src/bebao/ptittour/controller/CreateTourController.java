package bebao.ptittour.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import bebao.ptittour.model.Blobstore;
import bebao.ptittour.model.CongTy;
import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Tour;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class CreateTourController extends Controller {

    TourService tourService = new TourService();
    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    
    @Override
    public Navigation run() throws Exception {
        //TODO:
        /*
         * kiem tra lai toan bo class nay
         * login check ? chua login thi bat login ? ko phai cty thi redirect ve home ?
         * lay cac bien tu session?
         * check lai cac dieu kien return forward
         */
//        System.out.println("Username doc tu requestScope: " + requestScope("username").toString());
        HttpSession session = request.getSession();
//        String username = null;
//        String userType = null;
        
        if (!session.getAttribute("loggedin").equals("true")) {
            System.out.println("Login Status tu session: " + session.getAttribute("loggedin"));
            return forward("login");
        }
        else if((session.getAttribute("userType").equals("khach"))) {// && (session.getAttribute("loggedin") == "true"))
            System.out.println("User Khach khong co quyen thuc thi tac vu nay");
            return forward("index");
        }
        else {
//            if (!validate()){
//                System.out.println("Check lai input!");
//                request.setAttribute("error","Vui long kiem tra lai input");
//                return redirect("/addTour?error="+"Vui lòng kiểm tra lại input");
//            }
            
            
            
            String username = session.getAttribute("username").toString();
            DiaDiem ddXP = ddService.findDiaDiemByName(request.getParameter("add_ddXP").toString());
            DiaDiem ddDich = ddService.findDiaDiemByName(request.getParameter("add_ddDich").toString());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date ngayXP = sdf.parse(request.getParameter("add_ngayXP").toString());
            
//            request.removeAttribute("add_ddXP");
//            request.removeAttribute("add_ddDich");
            
            Tour newTour = new Tour();
//            BeanUtil.copy(request, newTour);
            
            newTour.setTen(request.getParameter("add_ten").toString());
            newTour.setMoTa(request.getParameter("add_mota").toString());
            newTour.setThoiGian(Integer.parseInt(request.getParameter("add_thoiGian").toString()));
            newTour.setGia(Integer.parseInt(request.getParameter("add_gia").toString()));
            newTour.setNgayXP(ngayXP);
            newTour.setSoLuong(Integer.parseInt(request.getParameter("add_soLuong").toString()));
            
            newTour.getCtyRef().setModel((CongTy) userService.findUserByUsername(username));
            newTour.getDdXPRef().setModel(ddXP);
            newTour.getDdDichRef().setModel(ddDich);
            
            BlobstoreService bs = BlobstoreServiceFactory.getBlobstoreService();
            Map<String, List<BlobKey>> blobs = bs.getUploads(request);
            List<BlobKey> blobKeyList = blobs.get("add_imgKey");
            Blobstore blobstore = new Blobstore();
            if ((blobKeyList != null) || (blobKeyList.size()>0)) {
                Key key = Datastore.createKey(Blobstore.class, blobKeyList.get(0).getKeyString());
                
                blobstore.setKey(key);
                Datastore.put(blobstore);
//                newTour.setImg(img);
            } 
//            else {
//                newTour.setImg(null);
//            }
            newTour.getImgRef().setModel(blobstore);
            System.out.println("key name cua img: " + newTour.getImgRef().getModel().getKey().getName());
            
            System.out.println(newTour.getCtyRef().getModel().getUsername());
            System.out.println(newTour.getDdXPRef().getModel().getName() + " >> " +newTour.getDdDichRef().getModel().getName());
            //TODO: bo comment dong duoi de luu
            Tour result = tourService.addTour(newTour);
            requestScope("ddXP", ddXP);
            requestScope("ddDich", ddDich);
            requestScope("tour", result);
//            requestScope("tourKey", newTour.getKey().toString());
            System.out.println("Reach the end:" + result.getTen() + " - " + result.getKey().getId()) ; // >>> lay duoc ten roi
//            System.out.println(Datastore.createKey(Tour.class, result.getKey().getId()).toString());
//            Key tourKey = tourService.getTourKey(result);
            String tourKey = KeyFactory.createKeyString("Tour", result.getKey().getId());
            System.out.println(tourKey.toString());
//            Thread.sleep(2000);
            return redirect("/viewTour?tourKey=" + tourKey);
        }
        
        /*
        //Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (session.getAttribute("loggedin") == "true") {
            username = session.getAttribute("username").toString();
            userType = session.getAttribute("userType").toString();
        }
        //System.out.println(username + " - type - " + userType);
        
        //NOTWorked: BeanUtil.copy(request, newTour);
        //Worked: System.out.println(request.getAttribute("ddXP") + " >> " + request.getAttribute("ddDich"));
        try {
            DiaDiem ddXP = ddService.findDiaDiemByName(request.getAttribute("ddXP").toString());
            DiaDiem ddDich = ddService.findDiaDiemByName(request.getAttribute("ddDich").toString());
            //System.out.println(ddXP.getName() + " >> " + ddDich.getName());
        
            if ((ddXP != null) && (ddDich != null)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date ngayXP = sdf.parse(request.getParameter("ngayXP"));
                if(ngayXP.after(new Date())){
                    request.removeAttribute("ddXP");
                    request.removeAttribute("ddDich");
                    
                    Tour newTour = new Tour();
                    BeanUtil.copy(request, newTour);
                    //copy cac input co cung ten vao doi tuong va thuoc tinh tuong ung cua doi tuong
                    //request co 1 input "name" thi se copy gia tri do vao newTour.name
                    newTour.getCtyRef().setModel((CongTy) userService.findUserByUsername(username));
                    newTour.getDdXPRef().setModel(ddXP);
                    newTour.getDdDichRef().setModel(ddDich);
                    System.out.println(newTour.getCtyRef().getModel().getUsername());
                    System.out.println(newTour.getDdXPRef().getModel().getName() + " >> " +newTour.getDdDichRef().getModel().getName());
                    //TODO: bo comment dong duoi de luu
                    tourService.addTour(newTour);
                    requestScope("tour", newTour);
                    return forward("viewTour.jsp");
                } else {
                    System.out.println("NgayXP ko hop le");
                }
                
            } else {
                //TODO: thong bao error
                System.out.println("Khong tim thay ddXP hoac ddDich");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        */
        
//        return forward("addTour");
    }
    
    protected boolean validate(){
        Validators v = new Validators(request);
        v.add("add_ten", v.required());
//        v.add("add_mota", v.required());
//        v.add("add_thoiGian",v.required());
//        v.add("add_gia",v.required());
//        v.add("add_ngayXP", v.required());
//        v.add("add_ddXP", v.required());
//        v.add("add_ddDich", v.required());
//        v.add("add_soLuong", v.required());
        return v.validate();
    }
}
