package bebao.ptittour.model;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;
    @Attribute(version = true)
    private Long version;
    @Attribute
    int soLuong;
    @Attribute
    Date ngayMua;
    @Attribute(persistent = false)
    String khachname;
    @Attribute
    private ModelRef<Khach> khachRef = new ModelRef<Khach>(Khach.class);
    @Attribute(persistent = false)
    String tourname;
    @Attribute
    private ModelRef<Tour> tourRef = new ModelRef<Tour>(Tour.class);
    @Attribute (persistent = false)
    Key tourKey;
    @Attribute (persistent = false)
    String ctyname;
    @Attribute (persistent = false)
    int bookingNumber;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Booking other = (Booking) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public ModelRef<Khach> getKhachRef() {
        return khachRef;
    }

    public ModelRef<Tour> getTourRef() {
        return tourRef;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getKhachname() {
        return khachname;
    }

    public void setKhachname(String khachname) {
        this.khachname = khachname;
    }

    public String getTourname() {
        return tourname;
    }

    public void setTourname(String tourname) {
        this.tourname = tourname;
    }

    public String getCtyname() {
        return ctyname;
    }

    public void setCtyname(String ctyname) {
        this.ctyname = ctyname;
    }

    public Key getTourKey() {
        return tourKey;
    }

    public void setTourKey(Key tourKey) {
        this.tourKey = tourKey;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
}
