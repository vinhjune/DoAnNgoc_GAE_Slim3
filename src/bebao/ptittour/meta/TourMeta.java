package bebao.ptittour.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-12-19 19:39:48")
/** */
public final class TourMeta extends org.slim3.datastore.ModelMeta<bebao.ptittour.model.Tour> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Tour, org.slim3.datastore.ModelRef<bebao.ptittour.model.CongTy>, bebao.ptittour.model.CongTy> ctyRef = new org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Tour, org.slim3.datastore.ModelRef<bebao.ptittour.model.CongTy>, bebao.ptittour.model.CongTy>(this, "ctyRef", "ctyRef", org.slim3.datastore.ModelRef.class, bebao.ptittour.model.CongTy.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Tour, org.slim3.datastore.ModelRef<bebao.ptittour.model.DiaDiem>, bebao.ptittour.model.DiaDiem> ddDichRef = new org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Tour, org.slim3.datastore.ModelRef<bebao.ptittour.model.DiaDiem>, bebao.ptittour.model.DiaDiem>(this, "ddDichRef", "ddDichRef", org.slim3.datastore.ModelRef.class, bebao.ptittour.model.DiaDiem.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Tour, org.slim3.datastore.ModelRef<bebao.ptittour.model.DiaDiem>, bebao.ptittour.model.DiaDiem> ddXPRef = new org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Tour, org.slim3.datastore.ModelRef<bebao.ptittour.model.DiaDiem>, bebao.ptittour.model.DiaDiem>(this, "ddXPRef", "ddXPRef", org.slim3.datastore.ModelRef.class, bebao.ptittour.model.DiaDiem.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.lang.Integer> gia = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.lang.Integer>(this, "gia", "gia", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Tour, org.slim3.datastore.ModelRef<bebao.ptittour.model.Blobstore>, bebao.ptittour.model.Blobstore> imgRef = new org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.Tour, org.slim3.datastore.ModelRef<bebao.ptittour.model.Blobstore>, bebao.ptittour.model.Blobstore>(this, "imgRef", "imgRef", org.slim3.datastore.ModelRef.class, bebao.ptittour.model.Blobstore.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<bebao.ptittour.model.Tour> moTa = new org.slim3.datastore.StringUnindexedAttributeMeta<bebao.ptittour.model.Tour>(this, "moTa", "moTa");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.util.Date> ngayXP = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.util.Date>(this, "ngayXP", "ngayXP", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.lang.Integer> soLuong = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.lang.Integer>(this, "soLuong", "soLuong", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Tour> ten = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Tour>(this, "ten", "ten");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.lang.Integer> thoiGian = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.lang.Integer>(this, "thoiGian", "thoiGian", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Tour, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TourMeta slim3_singleton = new TourMeta();

    /**
     * @return the singleton
     */
    public static TourMeta get() {
       return slim3_singleton;
    }

    /** */
    public TourMeta() {
        super("Tour", bebao.ptittour.model.Tour.class);
    }

    @Override
    public bebao.ptittour.model.Tour entityToModel(com.google.appengine.api.datastore.Entity entity) {
        bebao.ptittour.model.Tour model = new bebao.ptittour.model.Tour();
        if (model.getCtyRef() == null) {
            throw new NullPointerException("The property(ctyRef) is null.");
        }
        model.getCtyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("ctyRef"));
        if (model.getDdDichRef() == null) {
            throw new NullPointerException("The property(ddDichRef) is null.");
        }
        model.getDdDichRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("ddDichRef"));
        if (model.getDdXPRef() == null) {
            throw new NullPointerException("The property(ddXPRef) is null.");
        }
        model.getDdXPRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("ddXPRef"));
        model.setGia(longToPrimitiveInt((java.lang.Long) entity.getProperty("gia")));
        if (model.getImgRef() == null) {
            throw new NullPointerException("The property(imgRef) is null.");
        }
        model.getImgRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("imgRef"));
        model.setKey(entity.getKey());
        model.setMoTa(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("moTa")));
        model.setNgayXP((java.util.Date) entity.getProperty("ngayXP"));
        model.setSoLuong(longToPrimitiveInt((java.lang.Long) entity.getProperty("soLuong")));
        model.setTen((java.lang.String) entity.getProperty("ten"));
        model.setThoiGian(longToPrimitiveInt((java.lang.Long) entity.getProperty("thoiGian")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        bebao.ptittour.model.Tour m = (bebao.ptittour.model.Tour) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getCtyRef() == null) {
            throw new NullPointerException("The property(ctyRef) must not be null.");
        }
        entity.setProperty("ctyRef", m.getCtyRef().getKey());
        if (m.getDdDichRef() == null) {
            throw new NullPointerException("The property(ddDichRef) must not be null.");
        }
        entity.setProperty("ddDichRef", m.getDdDichRef().getKey());
        if (m.getDdXPRef() == null) {
            throw new NullPointerException("The property(ddXPRef) must not be null.");
        }
        entity.setProperty("ddXPRef", m.getDdXPRef().getKey());
        entity.setProperty("gia", m.getGia());
        if (m.getImgRef() == null) {
            throw new NullPointerException("The property(imgRef) must not be null.");
        }
        entity.setProperty("imgRef", m.getImgRef().getKey());
        entity.setUnindexedProperty("moTa", stringToText(m.getMoTa()));
        entity.setProperty("ngayXP", m.getNgayXP());
        entity.setProperty("soLuong", m.getSoLuong());
        entity.setProperty("ten", m.getTen());
        entity.setProperty("thoiGian", m.getThoiGian());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        bebao.ptittour.model.Tour m = (bebao.ptittour.model.Tour) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        bebao.ptittour.model.Tour m = (bebao.ptittour.model.Tour) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        bebao.ptittour.model.Tour m = (bebao.ptittour.model.Tour) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        bebao.ptittour.model.Tour m = (bebao.ptittour.model.Tour) model;
        if (m.getCtyRef() == null) {
            throw new NullPointerException("The property(ctyRef) must not be null.");
        }
        m.getCtyRef().assignKeyIfNecessary(ds);
        if (m.getDdDichRef() == null) {
            throw new NullPointerException("The property(ddDichRef) must not be null.");
        }
        m.getDdDichRef().assignKeyIfNecessary(ds);
        if (m.getDdXPRef() == null) {
            throw new NullPointerException("The property(ddXPRef) must not be null.");
        }
        m.getDdXPRef().assignKeyIfNecessary(ds);
        if (m.getImgRef() == null) {
            throw new NullPointerException("The property(imgRef) must not be null.");
        }
        m.getImgRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        bebao.ptittour.model.Tour m = (bebao.ptittour.model.Tour) model;
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
        bebao.ptittour.model.Tour m = (bebao.ptittour.model.Tour) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getBigThumbnailUrl() != null){
            writer.setNextPropertyName("bigThumbnailUrl");
            encoder0.encode(writer, m.getBigThumbnailUrl());
        }
        if(m.getBrief() != null){
            writer.setNextPropertyName("brief");
            encoder0.encode(writer, m.getBrief());
        }
        if(m.getCtyName() != null){
            writer.setNextPropertyName("ctyName");
            encoder0.encode(writer, m.getCtyName());
        }
        if(m.getCtyRef() != null && m.getCtyRef().getKey() != null){
            writer.setNextPropertyName("ctyRef");
            encoder0.encode(writer, m.getCtyRef(), maxDepth, currentDepth);
        }
        if(m.getDdDich() != null){
            writer.setNextPropertyName("ddDich");
            encoder0.encode(writer, m.getDdDich());
        }
        if(m.getDdDichRef() != null && m.getDdDichRef().getKey() != null){
            writer.setNextPropertyName("ddDichRef");
            encoder0.encode(writer, m.getDdDichRef(), maxDepth, currentDepth);
        }
        if(m.getDdXP() != null){
            writer.setNextPropertyName("ddXP");
            encoder0.encode(writer, m.getDdXP());
        }
        if(m.getDdXPRef() != null && m.getDdXPRef().getKey() != null){
            writer.setNextPropertyName("ddXPRef");
            encoder0.encode(writer, m.getDdXPRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("gia");
        encoder0.encode(writer, m.getGia());
        if(m.getImgKey() != null){
            writer.setNextPropertyName("imgKey");
            encoder0.encode(writer, m.getImgKey());
        }
        if(m.getImgRef() != null && m.getImgRef().getKey() != null){
            writer.setNextPropertyName("imgRef");
            encoder0.encode(writer, m.getImgRef(), maxDepth, currentDepth);
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getMoTa() != null){
            writer.setNextPropertyName("moTa");
            encoder0.encode(writer, m.getMoTa());
        }
        if(m.getNgayXP() != null){
            writer.setNextPropertyName("ngayXP");
            encoder0.encode(writer, m.getNgayXP());
        }
        writer.setNextPropertyName("soLuong");
        encoder0.encode(writer, m.getSoLuong());
        if(m.getTen() != null){
            writer.setNextPropertyName("ten");
            encoder0.encode(writer, m.getTen());
        }
        writer.setNextPropertyName("thoiGian");
        encoder0.encode(writer, m.getThoiGian());
        if(m.getThumbnailUrl() != null){
            writer.setNextPropertyName("thumbnailUrl");
            encoder0.encode(writer, m.getThumbnailUrl());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected bebao.ptittour.model.Tour jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        bebao.ptittour.model.Tour m = new bebao.ptittour.model.Tour();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("bigThumbnailUrl");
        m.setBigThumbnailUrl(decoder0.decode(reader, m.getBigThumbnailUrl()));
        reader = rootReader.newObjectReader("brief");
        m.setBrief(decoder0.decode(reader, m.getBrief()));
        reader = rootReader.newObjectReader("ctyName");
        m.setCtyName(decoder0.decode(reader, m.getCtyName()));
        reader = rootReader.newObjectReader("ctyRef");
        decoder0.decode(reader, m.getCtyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("ddDich");
        m.setDdDich(decoder0.decode(reader, m.getDdDich()));
        reader = rootReader.newObjectReader("ddDichRef");
        decoder0.decode(reader, m.getDdDichRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("ddXP");
        m.setDdXP(decoder0.decode(reader, m.getDdXP()));
        reader = rootReader.newObjectReader("ddXPRef");
        decoder0.decode(reader, m.getDdXPRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("gia");
        m.setGia(decoder0.decode(reader, m.getGia()));
        reader = rootReader.newObjectReader("imgKey");
        m.setImgKey(decoder0.decode(reader, m.getImgKey()));
        reader = rootReader.newObjectReader("imgRef");
        decoder0.decode(reader, m.getImgRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("moTa");
        m.setMoTa(decoder0.decode(reader, m.getMoTa()));
        reader = rootReader.newObjectReader("ngayXP");
        m.setNgayXP(decoder0.decode(reader, m.getNgayXP()));
        reader = rootReader.newObjectReader("soLuong");
        m.setSoLuong(decoder0.decode(reader, m.getSoLuong()));
        reader = rootReader.newObjectReader("ten");
        m.setTen(decoder0.decode(reader, m.getTen()));
        reader = rootReader.newObjectReader("thoiGian");
        m.setThoiGian(decoder0.decode(reader, m.getThoiGian()));
        reader = rootReader.newObjectReader("thumbnailUrl");
        m.setThumbnailUrl(decoder0.decode(reader, m.getThumbnailUrl()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}