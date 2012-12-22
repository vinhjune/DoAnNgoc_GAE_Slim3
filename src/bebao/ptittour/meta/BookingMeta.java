package bebao.ptittour.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-12-19 19:39:49")
/** */
public final class BookingMeta extends org.slim3.datastore.ModelMeta<bebao.ptittour.model.Booking> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Booking, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Booking, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Booking, org.slim3.datastore.ModelRef<bebao.ptittour.model.Khach>, bebao.ptittour.model.Khach> khachRef = new org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Booking, org.slim3.datastore.ModelRef<bebao.ptittour.model.Khach>, bebao.ptittour.model.Khach>(this, "khachRef", "khachRef", org.slim3.datastore.ModelRef.class, bebao.ptittour.model.Khach.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Booking, java.util.Date> ngayMua = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Booking, java.util.Date>(this, "ngayMua", "ngayMua", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Booking, java.lang.Integer> soLuong = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Booking, java.lang.Integer>(this, "soLuong", "soLuong", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Booking, org.slim3.datastore.ModelRef<bebao.ptittour.model.Tour>, bebao.ptittour.model.Tour> tourRef = new org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Booking, org.slim3.datastore.ModelRef<bebao.ptittour.model.Tour>, bebao.ptittour.model.Tour>(this, "tourRef", "tourRef", org.slim3.datastore.ModelRef.class, bebao.ptittour.model.Tour.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Booking, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Booking, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final BookingMeta slim3_singleton = new BookingMeta();

    /**
     * @return the singleton
     */
    public static BookingMeta get() {
       return slim3_singleton;
    }

    /** */
    public BookingMeta() {
        super("Booking", bebao.ptittour.model.Booking.class);
    }

    @Override
    public bebao.ptittour.model.Booking entityToModel(com.google.appengine.api.datastore.Entity entity) {
        bebao.ptittour.model.Booking model = new bebao.ptittour.model.Booking();
        model.setKey(entity.getKey());
        if (model.getKhachRef() == null) {
            throw new NullPointerException("The property(khachRef) is null.");
        }
        model.getKhachRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("khachRef"));
        model.setNgayMua((java.util.Date) entity.getProperty("ngayMua"));
        model.setSoLuong(longToPrimitiveInt((java.lang.Long) entity.getProperty("soLuong")));
        if (model.getTourRef() == null) {
            throw new NullPointerException("The property(tourRef) is null.");
        }
        model.getTourRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("tourRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        bebao.ptittour.model.Booking m = (bebao.ptittour.model.Booking) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getKhachRef() == null) {
            throw new NullPointerException("The property(khachRef) must not be null.");
        }
        entity.setProperty("khachRef", m.getKhachRef().getKey());
        entity.setProperty("ngayMua", m.getNgayMua());
        entity.setProperty("soLuong", m.getSoLuong());
        if (m.getTourRef() == null) {
            throw new NullPointerException("The property(tourRef) must not be null.");
        }
        entity.setProperty("tourRef", m.getTourRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        bebao.ptittour.model.Booking m = (bebao.ptittour.model.Booking) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        bebao.ptittour.model.Booking m = (bebao.ptittour.model.Booking) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        bebao.ptittour.model.Booking m = (bebao.ptittour.model.Booking) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        bebao.ptittour.model.Booking m = (bebao.ptittour.model.Booking) model;
        if (m.getKhachRef() == null) {
            throw new NullPointerException("The property(khachRef) must not be null.");
        }
        m.getKhachRef().assignKeyIfNecessary(ds);
        if (m.getTourRef() == null) {
            throw new NullPointerException("The property(tourRef) must not be null.");
        }
        m.getTourRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        bebao.ptittour.model.Booking m = (bebao.ptittour.model.Booking) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        bebao.ptittour.model.Booking m = (bebao.ptittour.model.Booking) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("bookingNumber");
        encoder0.encode(writer, m.getBookingNumber());
        if(m.getCtyname() != null){
            writer.setNextPropertyName("ctyname");
            encoder0.encode(writer, m.getCtyname());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getKhachRef() != null && m.getKhachRef().getKey() != null){
            writer.setNextPropertyName("khachRef");
            encoder0.encode(writer, m.getKhachRef(), maxDepth, currentDepth);
        }
        if(m.getKhachname() != null){
            writer.setNextPropertyName("khachname");
            encoder0.encode(writer, m.getKhachname());
        }
        if(m.getNgayMua() != null){
            writer.setNextPropertyName("ngayMua");
            encoder0.encode(writer, m.getNgayMua());
        }
        writer.setNextPropertyName("soLuong");
        encoder0.encode(writer, m.getSoLuong());
        if(m.getTourKey() != null){
            writer.setNextPropertyName("tourKey");
            encoder0.encode(writer, m.getTourKey());
        }
        if(m.getTourRef() != null && m.getTourRef().getKey() != null){
            writer.setNextPropertyName("tourRef");
            encoder0.encode(writer, m.getTourRef(), maxDepth, currentDepth);
        }
        if(m.getTourname() != null){
            writer.setNextPropertyName("tourname");
            encoder0.encode(writer, m.getTourname());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected bebao.ptittour.model.Booking jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        bebao.ptittour.model.Booking m = new bebao.ptittour.model.Booking();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("bookingNumber");
        m.setBookingNumber(decoder0.decode(reader, m.getBookingNumber()));
        reader = rootReader.newObjectReader("ctyname");
        m.setCtyname(decoder0.decode(reader, m.getCtyname()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("khachRef");
        decoder0.decode(reader, m.getKhachRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("khachname");
        m.setKhachname(decoder0.decode(reader, m.getKhachname()));
        reader = rootReader.newObjectReader("ngayMua");
        m.setNgayMua(decoder0.decode(reader, m.getNgayMua()));
        reader = rootReader.newObjectReader("soLuong");
        m.setSoLuong(decoder0.decode(reader, m.getSoLuong()));
        reader = rootReader.newObjectReader("tourKey");
        m.setTourKey(decoder0.decode(reader, m.getTourKey()));
        reader = rootReader.newObjectReader("tourRef");
        decoder0.decode(reader, m.getTourRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("tourname");
        m.setTourname(decoder0.decode(reader, m.getTourname()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}