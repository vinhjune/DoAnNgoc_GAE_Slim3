package bebao.ptittour.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.sun.xml.internal.ws.client.RequestContext;

import bebao.ptittour.model.Booking;
import bebao.ptittour.model.Khach;
import bebao.ptittour.model.Tour;
import bebao.ptittour.service.BookingService;
import bebao.ptittour.service.TourService;
import bebao.ptittour.service.UserService;

public class BuyTourController extends Controller {

    @Override
    public Navigation run() throws Exception {
        TourService tourService = new TourService();
        BookingService bookingService = new BookingService();
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        Tour tour = tourService.findTourByKey(requestScope("key").toString()); 
        int no = Integer.parseInt(requestScope("no").toString());
        if ((tour.getSoLuong() - no) < 0){
            System.out.println("Khong con du cho cho tour nay");
        }
        else {
            //TODO: 
            //giam soLuong cua Tour
//            tour.setSoLuong(tour.getSoLuong()-no);
            //tourService.updateMuaTour(tour.getKey(), no);
            
            //them booking
            if (no != 0){
                Booking booking = new Booking();
                booking.setNgayMua(new Date());
                booking.setSoLuong(no);
                booking.getTourRef().setModel(tour);
                String username = (String) session.getAttribute("username");
                System.out.println("1. Lay tu session: " + username);
                Khach khach = (Khach) userService.findUserByUsername(username);
                System.out.println("2. Lay tu khach: " + khach.getHoTen());
                booking.getKhachRef().setModel(khach);
                booking = bookingService.addBooking(booking);
                bookingService.completeBookingInfo(booking);
                requestScope("booking", booking);
//                requestScope("bookingKey", booking.getKey().getName());
            }
        }
        return forward("/viewBooking");
        //TODO: return ve trang ket qua mua tour
    }
}
