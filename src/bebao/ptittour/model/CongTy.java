package bebao.ptittour.model;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import bebao.ptittour.model.User;

@Model(schemaVersion = 1)
public class CongTy extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Attribute(persistent = false)
    private InverseModelListRef<CongTyTour, CongTy> congTyTourListRef = 
            new InverseModelListRef<CongTyTour, CongTy>(CongTyTour.class, "congTyRef", this);
   
    @Attribute(persistent = false)
    private InverseModelListRef<Tour, CongTy> ctyListRef = 
            new InverseModelListRef<Tour, CongTy>(Tour.class, "ctyRef", this);
    
    public CongTy() {
        super();
        setType("congty");
    }

    public InverseModelListRef<CongTyTour, CongTy> getCongTyTourListRef() {
        return congTyTourListRef;
    }

    public InverseModelListRef<Tour, CongTy> getCtyListRef() {
        return ctyListRef;
    }
}
