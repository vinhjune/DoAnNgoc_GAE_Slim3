package bebao.ptittour.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.Filter;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

import bebao.ptittour.meta.CongTyMeta;
import bebao.ptittour.meta.DiaDiemMeta;
import bebao.ptittour.meta.TourMeta;
import bebao.ptittour.meta.UserMeta;
import bebao.ptittour.model.CongTy;
import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Tour;


public class TourService {
    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    TourMeta tourMeta = new TourMeta();
    
    public Tour addTour(Tour newTour){
        //tao transaction
        Transaction tx = Datastore.beginTransaction();
        //insert tour vao datastore
        Datastore.put(newTour);
        //thuc hien tac vu insert
        tx.commit();
        completeRawTour(newTour);
        return newTour;
    }
    public Key getTourKey(Tour tour){
        List<Key> keys = Datastore.query(tourMeta)
                .filter(tourMeta.key.equal(tour.getKey()))
                .asKeyList();
        return keys.get(0);
    }
    /*
    public List<Tour> findTourByXP(String diemXP){
        return Datastore.query(tourMeta)
                .filter(tourMeta.ddXPRef.getName().equalsIgnoreCase(diemXP))
                .asList();
        return null;
    }
    */
    
    public List<Tour> listAllTourHistory(){
        // tuong duong voi 1 cau lenh SELECT trong SQL
        
        return Datastore.query(tourMeta)
                .sort(tourMeta.ngayXP.asc)
                .asList();
    }
    
    public List<Tour> listAllTour(){
        List<Tour> tours = Datastore.query(tourMeta)
                .sort(tourMeta.ngayXP.asc)
                .asList();
        List<Tour> outdates = new ArrayList<Tour>();
        for (Iterator iterator = tours.iterator(); iterator.hasNext();) {
            Tour tour = (Tour) iterator.next();
            if ((tour.getNgayXP()).before(new Date())){
                outdates.add(tour);
            } 
            else {
                this.completeRawTour(tour);
            }
        }
        tours.removeAll(outdates);
        
        return tours;
    }
    
    public List<Tour> findLastXTour(int x){
        List<Tour> tours = listAllTour();
        if (x < tours.size()){
            tours = tours.subList(0, x);
        }
        return tours;
    }
    
    public Tour findTourByKey(String strKey){
        Key key = Datastore.stringToKey(strKey);
        Tour tour =  Datastore.query(tourMeta)
                .filter(tourMeta.key.equal(key))
                .asSingle();
        completeRawTour(tour);
        System.out.println("Tour tim thay la : " + tour.getKey().toString());
        return tour;
    }
    
    public void completeRawTour(Tour tour){
        tour.setCtyName(tour.getCtyRef().getModel().getUsername());
        tour.setDdXP(tour.getDdXPRef().getModel().getName());
        tour.setDdDich(tour.getDdDichRef().getModel().getName());
        System.out.println(tour.getImgRef().getModel().getKey().getName());
        tour.setImgKey(KeyFactory.createKeyString("Blobstore", tour.getImgRef().getModel().getKey().getName()));
        
        BlobKey blobKey = new BlobKey(tour.getImgRef().getModel().getKey().getName());
        ImagesService imagesService = ImagesServiceFactory.getImagesService();
        
//        Image image = ImagesServiceFactory.makeImageFromBlob(blobKey); 
//        Transform resize = ImagesServiceFactory.makeResize(600, 800, true);
//        imagesService.applyTransform(resize, image);
        
        String imageUrl = imagesService.getServingUrl(blobKey, 250, false);
//        System.out.println("ImageURL sinh ra la:" + imageUrl);
        tour.setThumbnailUrl(imageUrl);
        String bigImageUrl = imagesService.getServingUrl(blobKey, 600, false);
        tour.setBigThumbnailUrl(bigImageUrl);
        /*
        if (tour.getMoTa().length() > 160) {
            tour.setBrief(tour.getMoTa().substring(0, 159));
        } else {
            tour.setBrief(tour.getMoTa());
        }
          */
    }
    /*
    public List<Tour> findTourByDiemXP(String diemXP){
        return Datastore.query(tourMeta)
                .filter(tourMeta.ddXPRef.equals(ddService.findDiaDiemByName(diemXP)))
                .asList();
    }
    */
    public List<Tour> findTourByDiemXP(String diemXP){
        DiaDiemMeta ddMeta = DiaDiemMeta.get();
        DiaDiem ddXP = Datastore.query(ddMeta)
                .filter(ddMeta.name.equal(diemXP))
                .asSingle();
        System.out.println("ddXP tim thay la: " + ddXP.getName() + "-----" + ddXP.getMoTa());
        //^^^ OK da tim thay dd ^^^^
        
        
//        Set<Key> keys = new HashSet<Key>();
        List<Tour> tours = ddXP.getDdXPListRef().getModelList();
        for (Iterator iterator = tours.iterator(); iterator.hasNext();) {
            Tour tour = (Tour) iterator.next();
            System.out.println("Tim thay tour tu ddXP: " + tour.getDdXPRef().getModel().getName() + " - " + tour.getDdDichRef().getModel().getName());
        }
//        Set<Tour> tours = new HashSet<Tour>();
        return tours;
    }
    
    public List<Tour> findTourByDiemDich(String diemDich){
        DiaDiemMeta ddMeta = DiaDiemMeta.get();
        DiaDiem ddDich = Datastore.query(ddMeta)
                .filter(ddMeta.name.equal(diemDich))
                .asSingle();
        System.out.println("ddDich tim thay la: " + ddDich.getName() + "-----" + ddDich.getMoTa());
        //^^^ OK da tim thay dd ^^^^
        
        
//        Set<Key> keys = new HashSet<Key>();
        List<Tour> tours = ddDich.getDdDichListRef().getModelList();
        for (Iterator iterator = tours.iterator(); iterator.hasNext();) {
            Tour tour = (Tour) iterator.next();
            System.out.println("Tim thay tour tu ddDich: " + tour.getDdXPRef().getModel().getName() + " - " + tour.getDdDichRef().getModel().getName());
        }
//        Set<Tour> tours = new HashSet<Tour>();
        return tours;
    }
    
    public List<Tour> findTourByCty(String cty){
        UserMeta ctyMeta = UserMeta.get();
        CongTy congty = (CongTy)Datastore.query(ctyMeta)
                .filter(ctyMeta.username.equal(cty))
                .asSingle();
        if (congty != null){
            List<Tour> tours = congty.getCtyListRef().getModelList();
            for (Iterator iterator = tours.iterator(); iterator.hasNext();) {
                Tour tour = (Tour) iterator.next();
                System.out.println("Tim thay tour tu cty: " + tour.getDdXPRef().getModel().getName() + " - " + tour.getDdDichRef().getModel().getName());
            }
            return tours;
        }
        else return null;
        
    }
    
    public List<Tour> findTourByNgayXP(String ngay){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayXP;
        try {
            ngayXP = sdf.parse(ngay);
            return Datastore.query(tourMeta)
                    .filter("ngayXP",FilterOperator.EQUAL,ngayXP)
                    .asList();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Tour> findTourByThoiGian(String thoiGian){
        return Datastore.query(tourMeta)
                .filter(tourMeta.thoiGian.equal(Integer.parseInt(thoiGian)))
                .asList();
                    
    }
    
    public List<Tour> findTourByGia(String gia){
        return Datastore.query(tourMeta)
                .filter(tourMeta.gia.lessThanOrEqual(Integer.parseInt(gia)))
                .asList();
    }
    
    
    public List<Tour> findTour(
        String diemXP, String diemDich,
        String ngayXP, String thoiGian,
        String gia, String cty) {

        List<Tour> tours = listAllTour();
        
        if((diemXP != "") && (diemXP != null)){
            List<Tour> tourXP = findTourByDiemXP(diemXP);
            tours.retainAll(tourXP);
        }
        
        if ((diemDich != "") && (diemDich != null)){
            List<Tour> tourDich = findTourByDiemDich(diemDich);
            tours.retainAll(tourDich);
        }
        
        if ((ngayXP != "") && (ngayXP != null) && (!ngayXP.equals("Ngày khởi hành"))) {
            List<Tour> tourNgayXP = findTourByNgayXP(ngayXP);
            tours.retainAll(tourNgayXP);
        }
        if((thoiGian != "") && (thoiGian != null) && (!thoiGian.equals("Thời gian (Ngày)"))){
            List<Tour> tourThoiGian = findTourByThoiGian(thoiGian);
            tours.retainAll(tourThoiGian);
        }
        if((gia != "") && (gia != null) && (!gia.equals("Giá (VNĐ)"))){
            List<Tour> tourGia = findTourByGia(gia);
            tours.retainAll(tourGia);
        }
        if((cty != "") && (cty != null)){
            List<Tour> tourCty = findTourByCty(cty);
            tours.retainAll(tourCty);
        }
        return tours;
        /*if (tours.isEmpty()){
            System.out.println("Ket qua: Khong tim thay tour phu hop");
            return null;
        }
        else {
            for (Iterator iterator = tours.iterator(); iterator.hasNext();) {
                Tour tour = (Tour) iterator.next();
                System.out.println("Ket qua: Tim thay tour: " + tour.getDdXPRef().getModel().getName() + " - " + tour.getDdDichRef().getModel().getName());
            }
            return tours;
        }*/
    }
/*
    public Tour updateMuaTour(Key key, int no){
        Tour tour = Datastore.get(Tour.class, key);
        tour.setSoLuong(tour.getSoLuong() - no);
        Datastore.put(tour);
        return tour;
    }
*/
}
