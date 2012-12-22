package bebao.ptittour.service;

import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

import bebao.ptittour.meta.PhuongTienMeta;
import bebao.ptittour.model.PhuongTien;


public class PhuongTienService {
    private PhuongTienMeta ptMeta = new PhuongTienMeta();
    
    public PhuongTien addPhuongTien(Map<String, Object> input){
        PhuongTien pt = new PhuongTien();
        
        BeanUtil.copy(input, pt);
        if (findPhuongTienByName(pt.getName()) == null) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(pt);
            tx.commit();
            
            return pt;
        }
        
        return null;
    }
    
    public PhuongTien findPhuongTienByName(String name){
        return Datastore.query(ptMeta)
                .filter(ptMeta.name.equal(name))
                .asSingle();
    }
}
