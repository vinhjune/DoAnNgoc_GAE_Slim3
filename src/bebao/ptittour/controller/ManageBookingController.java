package bebao.ptittour.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import bebao.ptittour.model.Booking;
import bebao.ptittour.model.CongTy;
import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Khach;
import bebao.ptittour.model.User;
import bebao.ptittour.service.BookingService;
import bebao.ptittour.service.DiaDiemService;
import bebao.ptittour.service.UserService;

public class ManageBookingController extends Controller {
    BookingService bookingService = new BookingService();
    UserService userService = new UserService();
    DiaDiemService ddService = new DiaDiemService();
    
    @Override
    public Navigation run() throws Exception {
        HttpSession session = request.getSession();
        List<Booking> bookings = null;
        
        if (session.getAttribute("userType").equals("khach")){
            Khach user = userService.findKhachByUsername(session.getAttribute("username").toString());
            if (user != null){
                bookings = bookingService.findBookingByKhach(user);
            } else {
                return null;
                //TODO: add bien ket qua tra ve
            }
        } else if (session.getAttribute("userType").equals("congTy")){
            CongTy user = userService.findCtyByUsername(session.getAttribute("username").toString());
            if (user != null){
                bookings = bookingService.findBookingByCty(user);
            } else {
                return null;
                //TODO: add bien ket qua tra ve
            }
        }
        requestScope("bookings", bookings);
        List<DiaDiem> listDd = ddService.listDiaDiem();
        requestScope("diaDiem", listDd);
        List<User> listCty = userService.listUserByType("congTy");
        requestScope("listCty",listCty);
        return forward("manageBooking.jsp");
    }
}
