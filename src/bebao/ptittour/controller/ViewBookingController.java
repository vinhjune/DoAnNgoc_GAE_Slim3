package bebao.ptittour.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import bebao.ptittour.model.Booking;
import bebao.ptittour.model.CongTy;
import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Khach;
import bebao.ptittour.model.Tour;
import bebao.ptittour.model.User;
import bebao.ptittour.service.BookingService;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class ViewBookingController extends Controller {
    UserService userService = new UserService();
    DiaDiemService ddService = new DiaDiemService();
    BookingService bookingService = new BookingService();
    TourService tourService = new TourService();
    
    @Override
    public Navigation run() throws Exception {
        if ((request.getParameter("bookingKey") == null) || (request.getParameter("bookingKey") == "")){
            Booking booking = requestScope("booking");
            Khach khach = booking.getKhachRef().getModel();
            Tour tour = booking.getTourRef().getModel();
            CongTy cty = tour.getCtyRef().getModel();
            requestScope("tour", tour);
            requestScope("cty", cty);
            requestScope("khach", khach);
            requestScope("booking", booking);
        } else {
            String bookingKey = request.getParameter("bookingKey");
            Booking booking = bookingService.findBookingByKey(bookingKey);
            Khach khach = booking.getKhachRef().getModel();
            Tour tour = booking.getTourRef().getModel();
            CongTy cty = tour.getCtyRef().getModel();
            tourService.completeRawTour(tour);
            requestScope("tour", tour);
            requestScope("cty", cty);
            requestScope("khach", khach);
            requestScope("booking", booking);
        }
        
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("viewBooking.jsp");
    }
}
