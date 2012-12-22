package bebao.ptittour.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-12-19 19:39:48")
/** */
public final class PhuongTienMeta extends org.slim3.datastore.ModelMeta<bebao.ptittour.model.PhuongTien> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.PhuongTien, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.PhuongTien, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.PhuongTien> name = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.PhuongTien>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.PhuongTien, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.PhuongTien, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PhuongTienMeta slim3_singleton = new PhuongTienMeta();

    /**
     * @return the singleton
     */
    public static PhuongTienMeta get() {
       return slim3_singleton;
    }

    /** */
    public PhuongTienMeta() {
        super("PhuongTien", bebao.ptittour.model.PhuongTien.class);
    }

    @Override
    public bebao.ptittour.model.PhuongTien entityToModel(com.google.appengine.api.datastore.Entity entity) {
        bebao.ptittour.model.PhuongTien model = new bebao.ptittour.model.PhuongTien();
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        bebao.ptittour.model.PhuongTien m = (bebao.ptittour.model.PhuongTien) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("name", m.getName());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        bebao.ptittour.model.PhuongTien m = (bebao.ptittour.model.PhuongTien) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        bebao.ptittour.model.PhuongTien m = (bebao.ptittour.model.PhuongTien) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        bebao.ptittour.model.PhuongTien m = (bebao.ptittour.model.PhuongTien) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        bebao.ptittour.model.PhuongTien m = (bebao.ptittour.model.PhuongTien) model;
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
        bebao.ptittour.model.PhuongTien m = (bebao.ptittour.model.PhuongTien) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected bebao.ptittour.model.PhuongTien jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        bebao.ptittour.model.PhuongTien m = new bebao.ptittour.model.PhuongTien();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}