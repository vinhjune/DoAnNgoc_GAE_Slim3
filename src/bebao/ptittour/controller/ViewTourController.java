package bebao.ptittour.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;

import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Tour;
import bebao.ptittour.model.User;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class ViewTourController extends Controller {
    TourService tourService = new TourService();
    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    
    @Override
    public Navigation run() throws Exception {
        String tourKey = requestScope("tourKey");
//WORK        System.out.println("TourKey fwd den la:" + tourKey);
        Tour tour = tourService.findTourByKey(tourKey);
//        System.out.println("Ten tour tim thay la:" + tour.getTen());
        
        //TODO: test ImagesService
//        BlobKey blobKey = new BlobKey(tour.getImgRef().getModel().getKey().getName());
//        ImagesService imagesService = ImagesServiceFactory.getImagesService();
//        String imageUrl = imagesService.getServingUrl(blobKey, 250, false);
//        System.out.println("ImageURL sinh ra la:" + imageUrl);
        
//        BlobKey blobKey = new BlobKey(tour.getImgRef().getModel().getKey());
        
        tourService.completeRawTour(tour);
        requestScope("tour", tour);
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("viewTour.jsp");
    }
}
