package bebao.ptittour.model;

import java.io.Serializable;
import java.util.Date;

import bebao.ptittour.meta.CongTyMeta;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.ModelRefAttributeMeta;

@Model(schemaVersion = 1)
public class Tour implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;
    @Attribute(version = true)
    private Long version;
    @Attribute
    private String ten;
//    @Attribute (lob = true)
//    private Blobstore img;
    @Attribute
    ModelRef<Blobstore> imgRef = new ModelRef<Blobstore>(Blobstore.class);
    @Attribute(persistent = false)
    private String imgKey;
    @Attribute(persistent = false)
    private String thumbnailUrl;
    @Attribute(persistent = false)
    private String bigThumbnailUrl;
    @Attribute
    ModelRef<CongTy> ctyRef = new ModelRef<CongTy>(CongTy.class);
    @Attribute(persistent = false)
    private String ctyName;
    @Attribute (lob = true)
    private String moTa;
    @Attribute (persistent = false) 
    private String brief;
    @Attribute
    private int thoiGian;
    @Attribute
    private int gia;
    @Attribute
    private Date ngayXP;
    @Attribute
    private int soLuong;
    @Attribute
    //private DiaDiem ddXP;
    private ModelRef<DiaDiem> ddXPRef = new ModelRef<DiaDiem>(DiaDiem.class);
    @Attribute(persistent = false)
    private String ddXP; 
    @Attribute
    //private DiaDiem ddDich;
    private ModelRef<DiaDiem> ddDichRef = new ModelRef<DiaDiem>(DiaDiem.class);
    @Attribute(persistent = false)
    private String ddDich;
    @Attribute(persistent = false)
    private InverseModelListRef<Booking, Tour> bookingTourListRef = 
        new InverseModelListRef<Booking, Tour>(Booking.class, "tourRef", this);
    @Attribute(persistent = false)
    private InverseModelListRef<CongTyTour, Tour> congTyTourListRef = 
        new InverseModelListRef<CongTyTour, Tour>(CongTyTour.class, "tourRef", this);
    @Attribute(persistent = false)
    private InverseModelListRef<TourDiaDiem, Tour> tourDiaDiemListRef = 
        new InverseModelListRef<TourDiaDiem, Tour>(TourDiaDiem.class, "tourRef", this);
    
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
        Tour other = (Tour) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Date getNgayXP() {
        return ngayXP;
    }

    public void setNgayXP(Date ngayXP) {
        this.ngayXP = ngayXP;
    }

    public ModelRef<DiaDiem> getDdXPRef() {
        return ddXPRef;
    }

    //public void setDdXP(DiaDiem ddXP) {
    //    this.ddXP = ddXP;
    //}

    public ModelRef<DiaDiem> getDdDichRef() {
        return ddDichRef;
    }

    //public void setDdDich(DiaDiem ddDich) {
    //    this.ddDich = ddDich;
    //}

    public InverseModelListRef<Booking, Tour> getBookingTourListRef() {
        return bookingTourListRef;
    }

    public InverseModelListRef<CongTyTour, Tour> getCongTyTourListRef() {
        return congTyTourListRef;
    }

    public InverseModelListRef<TourDiaDiem, Tour> getTourDiaDiemListRef() {
        return tourDiaDiemListRef;
    }

    public ModelRef<CongTy> getCtyRef() {
        return ctyRef;
    }

    public String getCtyName() {
        return ctyName;
    }

    public void setCtyName(String ctyName) {
        this.ctyName = ctyName;
    }

    public String getDdXP() {
        return ddXP;
    }

    public void setDdXP(String ddXP) {
        this.ddXP = ddXP;
    }

    public String getDdDich() {
        return ddDich;
    }

    public void setDdDich(String ddDich) {
        this.ddDich = ddDich;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
/*
    public Blobstore getImg() {
        return img;
    }

    public void setImg(Blobstore img) {
        this.img = img;
    }
*/
    public ModelRef<Blobstore> getImgRef() {
        return imgRef;
    }

    public String getImgKey() {
        return imgKey;
    }

    public void setImgKey(String imgKey) {
        this.imgKey = imgKey;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getBigThumbnailUrl() {
        return bigThumbnailUrl;
    }

    public void setBigThumbnailUrl(String bigThumbnailUrl) {
        this.bigThumbnailUrl = bigThumbnailUrl;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

}
