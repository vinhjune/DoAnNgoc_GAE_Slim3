package bebao.ptittour.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-12-19 19:39:48")
/** */
public final class KhachMeta extends org.slim3.datastore.ModelMeta<bebao.ptittour.model.Khach> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach> diaChi = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach>(this, "diaChi", "diaChi");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach> email = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach> hoTen = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach>(this, "hoTen", "hoTen");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Khach, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Khach, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Khach, java.util.Date> ngaySinh = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Khach, java.util.Date>(this, "ngaySinh", "ngaySinh", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach> password = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach>(this, "password", "password");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach> phone = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach>(this, "phone", "phone");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach> type = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach>(this, "type", "type");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach> username = new org.slim3.datastore.StringAttributeMeta<bebao.ptittour.model.Khach>(this, "username", "username");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Khach, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<bebao.ptittour.model.Khach, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final KhachMeta slim3_singleton = new KhachMeta();

    /**
     * @return the singleton
     */
    public static KhachMeta get() {
       return slim3_singleton;
    }

    /** */
    public KhachMeta() {
        super("User", bebao.ptittour.model.Khach.class, java.util.Arrays.asList("bebao.ptittour.model.Khach"));
    }

    @Override
    public bebao.ptittour.model.Khach entityToModel(com.google.appengine.api.datastore.Entity entity) {
        bebao.ptittour.model.Khach model = new bebao.ptittour.model.Khach();
        model.setDiaChi((java.lang.String) entity.getProperty("diaChi"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setHoTen((java.lang.String) entity.getProperty("hoTen"));
        model.setKey(entity.getKey());
        model.setNgaySinh((java.util.Date) entity.getProperty("ngaySinh"));
        model.setPassword((java.lang.String) entity.getProperty("password"));
        model.setPhone((java.lang.String) entity.getProperty("phone"));
        model.setType((java.lang.String) entity.getProperty("type"));
        model.setUsername((java.lang.String) entity.getProperty("username"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        bebao.ptittour.model.Khach m = (bebao.ptittour.model.Khach) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("diaChi", m.getDiaChi());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("hoTen", m.getHoTen());
        entity.setProperty("ngaySinh", m.getNgaySinh());
        entity.setProperty("password", m.getPassword());
        entity.setProperty("phone", m.getPhone());
        entity.setProperty("type", m.getType());
        entity.setProperty("username", m.getUsername());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        entity.setProperty("slim3.classHierarchyList", classHierarchyList);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        bebao.ptittour.model.Khach m = (bebao.ptittour.model.Khach) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        bebao.ptittour.model.Khach m = (bebao.ptittour.model.Khach) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        bebao.ptittour.model.Khach m = (bebao.ptittour.model.Khach) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        bebao.ptittour.model.Khach m = (bebao.ptittour.model.Khach) model;
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
        bebao.ptittour.model.Khach m = (bebao.ptittour.model.Khach) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getDiaChi() != null){
            writer.setNextPropertyName("diaChi");
            encoder0.encode(writer, m.getDiaChi());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getHoTen() != null){
            writer.setNextPropertyName("hoTen");
            encoder0.encode(writer, m.getHoTen());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getNgaySinh() != null){
            writer.setNextPropertyName("ngaySinh");
            encoder0.encode(writer, m.getNgaySinh());
        }
        if(m.getPassword() != null){
            writer.setNextPropertyName("password");
            encoder0.encode(writer, m.getPassword());
        }
        if(m.getPhone() != null){
            writer.setNextPropertyName("phone");
            encoder0.encode(writer, m.getPhone());
        }
        if(m.getType() != null){
            writer.setNextPropertyName("type");
            encoder0.encode(writer, m.getType());
        }
        if(m.getUsername() != null){
            writer.setNextPropertyName("username");
            encoder0.encode(writer, m.getUsername());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected bebao.ptittour.model.Khach jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        bebao.ptittour.model.Khach m = new bebao.ptittour.model.Khach();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("diaChi");
        m.setDiaChi(decoder0.decode(reader, m.getDiaChi()));
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("hoTen");
        m.setHoTen(decoder0.decode(reader, m.getHoTen()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("ngaySinh");
        m.setNgaySinh(decoder0.decode(reader, m.getNgaySinh()));
        reader = rootReader.newObjectReader("password");
        m.setPassword(decoder0.decode(reader, m.getPassword()));
        reader = rootReader.newObjectReader("phone");
        m.setPhone(decoder0.decode(reader, m.getPhone()));
        reader = rootReader.newObjectReader("type");
        m.setType(decoder0.decode(reader, m.getType()));
        reader = rootReader.newObjectReader("username");
        m.setUsername(decoder0.decode(reader, m.getUsername()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}