package bebao.ptittour.service;

import java.util.Iterator;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import bebao.ptittour.meta.BookingMeta;
import bebao.ptittour.meta.KhachMeta;
import bebao.ptittour.model.Booking;
import bebao.ptittour.model.CongTy;
import bebao.ptittour.model.Khach;
import bebao.ptittour.model.Tour;
import bebao.ptittour.model.User;


public class BookingService {
    BookingMeta bookingMeta = new BookingMeta();
    KhachMeta khachMeta = new KhachMeta();
    public Booking addBooking(Booking booking){
//        Key tourKey = booking.getTourRef().getModel().getKey();
        Tour tour = booking.getTourRef().getModel();
        int soLuong = booking.getSoLuong();
        tour.setSoLuong(tour.getSoLuong() - soLuong);

        Datastore.put(booking);
        Datastore.put(tour);
        
        return booking;
    }
    
    public List<Booking> findBookingByKhach(Khach user) {
        List<Booking> bookings = user.getKhachBookingListRef().getModelList();
        for (Iterator iterator = bookings.iterator(); iterator.hasNext();) {
            Booking booking = (Booking) iterator.next();
            completeBookingInfo(booking);
//WORKED
            System.out.println("Tim thay booking tuong ung voi khach la : " + booking.getKey());
        } 
        return bookings;
    }
    
    public List<Booking> findBookingByCty(CongTy user){
        List<Booking> bookings = null;
        TourService tourService = new TourService();
        List<Tour> tours = tourService.findTourByCty(user.getUsername());
        for (Iterator iterator = tours.iterator(); iterator.hasNext();) {
            Tour tour = (Tour) iterator.next();
//WORKED            
            System.out.println("Tim thay tour tuong ung voi cong ty la: " + tour.getTen());
            List<Booking> bookingsByTour = tour.getBookingTourListRef().getModelList();
            for (Iterator iterator2 = bookingsByTour.iterator(); iterator2.hasNext();) {
                Booking booking = (Booking) iterator2.next();
                completeBookingInfo(booking);
//WORKED                
                System.out.println("Tim thay booking tuong ung voi tour cua cong ty la:" + booking.getKey());
            }
            if ((bookings == null) || (bookings.isEmpty())) {
                bookings = bookingsByTour;
            } else {
                bookings.addAll(bookingsByTour);
            }
        }
        return bookings;
    }
    
    public Booking findBookingByKey(String strKey){
        Key key = Datastore.stringToKey(strKey);
        Booking booking =  Datastore.query(bookingMeta)
                .filter(bookingMeta.key.equal(key))
                .asSingle();
        completeBookingInfo(booking);
        System.out.println("Tour tim thay la : " + booking.getKey().toString());
        return booking;
    }
    
    public void completeBookingInfo(Booking booking){
        booking.setCtyname(booking.getTourRef().getModel().getCtyRef().getModel().getUsername());
        booking.setKhachname(booking.getKhachRef().getModel().getUsername());
        booking.setTourname(booking.getTourRef().getModel().getTen());
        booking.setTourKey(booking.getTourRef().getModel().getKey());
        booking.setBookingNumber(booking.getKey().hashCode());
    }
}




