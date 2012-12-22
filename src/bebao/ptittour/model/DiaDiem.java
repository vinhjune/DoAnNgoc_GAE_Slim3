package bebao.ptittour.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class DiaDiem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;
    @Attribute(version = true)
    private Long version;
    @Attribute
    private String name;
    @Attribute (lob = true)
    private String moTa;
    @Attribute(persistent = false)
    private InverseModelListRef<TourDiaDiem, DiaDiem> tourDiaDiemListRef = 
        new InverseModelListRef<TourDiaDiem, DiaDiem>(TourDiaDiem.class, "diaDiemRef", this);
    @Attribute(persistent = false)
    private InverseModelListRef<Tour, DiaDiem> ddXPListRef = 
            new InverseModelListRef<Tour, DiaDiem>(Tour.class, "ddXPRef", this);
    @Attribute(persistent = false)
    private InverseModelListRef<Tour, DiaDiem> ddDichListRef = 
            new InverseModelListRef<Tour, DiaDiem>(Tour.class, "ddDichRef", this);
    
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
        DiaDiem other = (DiaDiem) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public InverseModelListRef<TourDiaDiem, DiaDiem> getTourDiaDiemListRef() {
        return tourDiaDiemListRef;
    }

    public InverseModelListRef<Tour, DiaDiem> getDdXPListRef() {
        return ddXPListRef;
    }

    public InverseModelListRef<Tour, DiaDiem> getDdDichListRef() {
        return ddDichListRef;
    }
}
