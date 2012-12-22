package bebao.ptittour.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.Transaction;

import bebao.ptittour.meta.CongTyMeta;
import bebao.ptittour.meta.KhachMeta;
import bebao.ptittour.meta.UserMeta;
import bebao.ptittour.model.CongTy;
import bebao.ptittour.model.Khach;
import bebao.ptittour.model.User;


public class UserService {
    private UserMeta userMeta = new UserMeta();
    private KhachMeta khachMeta = new KhachMeta();
    private CongTyMeta congTyMeta = new CongTyMeta();
    
   /* public User register(Map<String, Object> input){
       //User newUser = new User();
       if (input.containsValue("khach")){
           //System.out.println("Khach");
           Khach khachDL = new Khach();
           BeanUtil.copy(input, khachDL);
           
           if ((findUserByUsername(khachDL.getUsername()) == null) && (findUserByEmail(khachDL.getEmail()) == null)){
               Transaction tx = Datastore.beginTransaction();
               Datastore.put(khachDL);
               tx.commit();
               
               //Worked: System.out.println(khachDL.getType() + ": " + khachDL.getUsername() );
               return khachDL;
           } else {
               System.out.println("Da co Khach trung username/email.");
           }
           //TODO: else de nghi nhap lai????
       } else if (input.containsValue("congTy")) {
           CongTy congTy = new CongTy();
           BeanUtil.copy(input, congTy);
           
           if ((findUserByUsername(congTy.getUsername()) == null) && (findUserByEmail(congTy.getEmail()) == null)){
               Transaction tx = Datastore.beginTransaction();
               Datastore.put(congTy);
               tx.commit();
               
               System.out.println(congTy.getType() + ": " + congTy.getUsername());
               return congTy;
           } else {
               System.out.println("Da co CongTy trung username/email.");
           }
           //TODO: else de nghi nhap lai??
       }
       
       return null;
    }*/
    public User register(User newUser){
       /* if (newUser.getType().equals("khach")){
            Transaction tx = Datastore.beginTransaction();
            Datastore.put((Khach) newUser);
            tx.commit();
            return newUser;
        }
        else if (newUser.getType().equals("congTy")) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.put((CongTy) newUser);
            tx.commit();
            return newUser;
        }
        else return null;*/
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(newUser);     // tuong duong voi lenh Insert trong SQL
        tx.commit();
        return newUser;
    }
    
    public User login(Map<String, Object> input){
        //if (!(input.isEmpty())){
            try {
                String username = input.get("username").toString();
                String password = input.get("password").toString();
                //Worked: System.out.println(username + " / " + password);
                
                if (checkLoginData(username, password) != null){
                    User user = checkLoginData(username, password);
                    //Worked: System.out.println("Tim thay user");
                    //TODO: set session
                    return user;
                } else {
                    //Worked: System.out.println("Khong tim thay user.");
                    //TODO: redo login
                    
                    return null;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        //}
        //return null;
        
    }
    
    public User findUserByUsername (String username){
        return Datastore.query(userMeta)
                .filter(userMeta.username.equal(username))
                .asSingle();
    }
    
    public Khach findKhachByUsername (String username){
        return (Khach) Datastore.query(userMeta)
                .filter(userMeta.username.equal(username))
                .asSingle();
    }
    
    public CongTy findCtyByUsername (String username){
        return (CongTy) Datastore.query(userMeta)
                .filter(userMeta.username.equal(username), userMeta.type.equal("congTy"))
                .asSingle();
    }
    
    public User findUserByEmail (String email){
        return Datastore.query(userMeta)
                .filter(userMeta.email.equal(email))
                .asSingle();
    }
    
    public User checkLoginData (String username, String password){
        return Datastore.query(userMeta)
                .filter(userMeta.username.equal(username), userMeta.password.equal(password))
                .asSingle();
    }
    
    public List<User> listUser() {
        return Datastore.query(userMeta)
                .sort(userMeta.username.asc)
                .asList();
    }
    
    public List<User> listUserByType(String type) {
        return Datastore.query(userMeta)
                .filter(userMeta.type.equal(type))
                .sort(userMeta.username.asc)
                .asList();
    }
}
