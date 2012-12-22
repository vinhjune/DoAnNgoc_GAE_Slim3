package bebao.ptittour.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import bebao.ptittour.meta.DiaDiemMeta;
import bebao.ptittour.model.DiaDiem;
import bebao.ptittour.model.Tour;


public class DiaDiemService {
    private DiaDiemMeta ddMeta = new DiaDiemMeta();
    
    public DiaDiem addDiaDiem(DiaDiem dd){
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(dd);
        tx.commit();
        return dd;
    }
    
    public DiaDiem findDiaDiemByName(String name){
        return Datastore.query(ddMeta)
                .filter(ddMeta.name.equal(name))
                .asSingle();
    }
    
    public List<DiaDiem> listDiaDiem(){
        return Datastore.query(ddMeta)
                .sort(ddMeta.name.asc)
                .asList();
        
    }
    
    public DiaDiem findDiaDiemByKey(String strKey){
        Key key = Datastore.stringToKey(strKey);
        return Datastore.query(ddMeta)
                .filter(ddMeta.key.equal(key))
                .asSingle();
    }
}
