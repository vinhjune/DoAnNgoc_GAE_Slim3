package bebao.ptittour.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Tour;
import bebao.ptittour.model.User;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class ListToursController extends Controller {
    TourService tourService = new TourService();
    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    @Override
    public Navigation run() throws Exception {
        List<Tour> tours = new ArrayList<Tour>();
        List<Tour> outdates = new ArrayList<Tour>();
        Date today = new Date();
        
        tours = tourService.listAllTour();
        
        
        /*for (Iterator iterator = tours.iterator(); iterator.hasNext();) {
            Tour tour = (Tour) iterator.next();
            if ((tour.getNgayXP()).before(today)){
                outdates.add(tour);
            } 
            else {
                tourService.completeRawTour(tour);
            }
        }
        tours.removeAll(outdates);*/
        if (!tours.isEmpty()){
            for (Iterator iterator = outdates.iterator(); iterator.hasNext();) {
                Tour tour = (Tour) iterator.next();
                tourService.completeRawTour(tour);
            }
            requestScope("tours", tours);
        }
        else {
            requestScope("error", "Khong tim thay tour phu hop");
        }
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("listTours.jsp");
    }
    
    
    
}
