package bebao.ptittour.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-12-19 19:39:48")
/** */
public final class TourDiaDiemMeta extends org.slim3.datastore.ModelMeta<bebao.ptittour.model.TourDiaDiem> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.TourDiaDiem, org.slim3.datastore.ModelRef<bebao.ptittour.model.DiaDiem>, bebao.ptittour.model.DiaDiem> diaDiemRef = new org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.TourDiaDiem, org.slim3.datastore.ModelRef<bebao.ptittour.model.DiaDiem>, bebao.ptittour.model.DiaDiem>(this, "diaDiemRef", "diaDiemRef", org.slim3.datastore.ModelRef.class, bebao.ptittour.model.DiaDiem.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.TourDiaDiem, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.TourDiaDiem, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.TourDiaDiem, org.slim3.datastore.ModelRef<bebao.ptittour.model.Tour>, bebao.ptittour.model.Tour> tourRef = new org.slim3.datastore.ModelRefAttributeMeta<bebao.ptittour.model.TourDiaDiem, org.slim3.datastore.ModelRef<bebao.ptittour.model.Tour>, bebao.ptittour.model.Tour>(this, "tourRef", "tourRef", org.slim3.datastore.ModelRef.class, bebao.ptittour.model.Tour.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.TourDiaDiem, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.TourDiaDiem, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TourDiaDiemMeta slim3_singleton = new TourDiaDiemMeta();

    /**
     * @return the singleton
     */
    public static TourDiaDiemMeta get() {
       return slim3_singleton;
    }

    /** */
    public TourDiaDiemMeta() {
        super("TourDiaDiem", bebao.ptittour.model.TourDiaDiem.class);
    }

    @Override
    public bebao.ptittour.model.TourDiaDiem entityToModel(com.google.appengine.api.datastore.Entity entity) {
        bebao.ptittour.model.TourDiaDiem model = new bebao.ptittour.model.TourDiaDiem();
        if (model.getDiaDiemRef() == null) {
            throw new NullPointerException("The property(diaDiemRef) is null.");
        }
        model.getDiaDiemRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("diaDiemRef"));
        model.setKey(entity.getKey());
        if (model.getTourRef() == null) {
            throw new NullPointerException("The property(tourRef) is null.");
        }
        model.getTourRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("tourRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        bebao.ptittour.model.TourDiaDiem m = (bebao.ptittour.model.TourDiaDiem) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getDiaDiemRef() == null) {
            throw new NullPointerException("The property(diaDiemRef) must not be null.");
        }
        entity.setProperty("diaDiemRef", m.getDiaDiemRef().getKey());
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
        bebao.ptittour.model.TourDiaDiem m = (bebao.ptittour.model.TourDiaDiem) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        bebao.ptittour.model.TourDiaDiem m = (bebao.ptittour.model.TourDiaDiem) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        bebao.ptittour.model.TourDiaDiem m = (bebao.ptittour.model.TourDiaDiem) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        bebao.ptittour.model.TourDiaDiem m = (bebao.ptittour.model.TourDiaDiem) model;
        if (m.getDiaDiemRef() == null) {
            throw new NullPointerException("The property(diaDiemRef) must not be null.");
        }
        m.getDiaDiemRef().assignKeyIfNecessary(ds);
        if (m.getTourRef() == null) {
            throw new NullPointerException("The property(tourRef) must not be null.");
        }
        m.getTourRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        bebao.ptittour.model.TourDiaDiem m = (bebao.ptittour.model.TourDiaDiem) model;
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
        bebao.ptittour.model.TourDiaDiem m = (bebao.ptittour.model.TourDiaDiem) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getDiaDiemRef() != null && m.getDiaDiemRef().getKey() != null){
            writer.setNextPropertyName("diaDiemRef");
            encoder0.encode(writer, m.getDiaDiemRef(), maxDepth, currentDepth);
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getTourRef() != null && m.getTourRef().getKey() != null){
            writer.setNextPropertyName("tourRef");
            encoder0.encode(writer, m.getTourRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected bebao.ptittour.model.TourDiaDiem jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        bebao.ptittour.model.TourDiaDiem m = new bebao.ptittour.model.TourDiaDiem();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("diaDiemRef");
        decoder0.decode(reader, m.getDiaDiemRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("tourRef");
        decoder0.decode(reader, m.getTourRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}