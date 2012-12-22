package bebao.ptittour.model;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import bebao.ptittour.model.User;

@Model(schemaVersion = 1)
public class Khach extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Attribute(persistent = false)
    private InverseModelListRef<Booking, Khach> khachBookingListRef = 
        new InverseModelListRef<Booking, Khach>(Booking.class, "khachRef", this);
   
    public InverseModelListRef<Booking, Khach> getKhachBookingListRef() {
        return khachBookingListRef;
    }

    public Khach() {
        super();
        setType("khach");
    }
    
    
}
