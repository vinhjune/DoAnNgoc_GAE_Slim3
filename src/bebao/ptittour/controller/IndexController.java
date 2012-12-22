package bebao.ptittour.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.KeyFactory;

import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Tour;
import bebao.ptittour.model.User;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class IndexController extends Controller {
    DiaDiemService ddService = new DiaDiemService();
    UserService userService = new UserService();
    @Override
    public Navigation run() throws Exception {
        HttpSession session = request.getSession();
        if (session.isNew()){
            session.setAttribute("loggedin", "");
            session.setAttribute("username", "");
            session.setAttribute("userType", "");
            session.setAttribute("date","");
        }
        TourService tourService = new TourService();
        List<Tour> tours = tourService.findLastXTour(5);
        for (Iterator iterator = tours.iterator(); iterator.hasNext();) {
            Tour tour = (Tour) iterator.next();
            System.out.println(KeyFactory.createKeyString("Tour", tour.getKey().getId()));
            tourService.completeRawTour(tour);
            System.out.println("Good");
        }
        requestScope("tours", tours);
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("index.jsp");
    }
}
