package hello;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
/*import org.hibernate.connection.C3P0ConnectionProvider;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;*/
import org.hibernate.internal.SessionFactoryImpl;
 
public class DBUser {
 SessionFactory sessionCreator;
 Session session;
 	DBUser(){
 		sessionCreator = SessionFactoryUtil.getSessionFactory();		
 	}
 	 public void finalize(){
 		 closeSessionFactory(sessionCreator);
 	 }
   /* public static void main(String[] args) {
        //Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
 
        //session.beginTransaction();
 
        //createPerson(session);
 
        //queryPerson(session);
 
    }*/
    
    /*public void startSession(){
    	session.beginTransaction();
    }*/
    private void closeSessionFactory(SessionFactory factory) { 
    	   if(factory instanceof SessionFactoryImpl) {
    	      SessionFactoryImpl sf = (SessionFactoryImpl)factory;
    	      ConnectionProvider conn = sf.getConnectionProvider();
    	      if(conn instanceof C3P0ConnectionProvider) { 
    	        ((C3P0ConnectionProvider)conn).close(); 
    	      }
    	   }
    	   factory.close();
    }
 
    /*private static void queryPerson(Session session) {
        Query query = session.createQuery("from User");                 
        List <User>list = query.list();
        java.util.Iterator<User> iter = list.iterator();
        while (iter.hasNext()) {
 
            User user = iter.next();
            System.out.println("Person: \"" + user.getName() +"\", " + user.getSurname() +"\", " +user.getBranch());
 
        }
 
        session.getTransaction().commit();
 
    }*/
    
    public ArrayList<User> listPerson() {
    	session = sessionCreator.openSession();
    	session.beginTransaction();
        Query query = session.createQuery("from User");                 
        ArrayList <User>list = (ArrayList<User>) query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public ArrayList<FunctionalityModel> personDetails(Integer personID) {
    	session = sessionCreator.openSession();
    	session.beginTransaction();
        Query query = session.createQuery("from FunctionalityModel D WHERE D.personId = ?").setParameter(0, personID); 
        //System.out.println(personID);
        //query.setString("personID",personID.toString());
        ArrayList <FunctionalityModel>list = (ArrayList<FunctionalityModel>) query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public ArrayList<PracticesModel> personPractice(Integer personID) {
    	session = sessionCreator.openSession();
    	session.beginTransaction();
    	Query query = session.createQuery("from PracticesModel P WHERE P.personId = ?").setParameter(0, personID);  
        //query.setString("personID",personID.toString());                
        ArrayList <PracticesModel>list = (ArrayList<PracticesModel>) query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    private int getNextId(){
    	int max=1;
    	Query query = session.createQuery("from User");                 
        List <User>list = query.list();
        java.util.Iterator<User> iter = list.iterator();
        while (iter.hasNext()) {
 
            User user = iter.next();
            if(max==user.getPersonId())
            	max++;
            if(max<user.getPersonId())
            	max=user.getPersonId();
          
        }
        return max;
    }
 
    public void savePerson(User user) {
    	session = sessionCreator.openSession();
    	session.beginTransaction();

        user.setPersonId(getNextId());
        Iterator<Account> a=user.getAccount().iterator();
        while(a.hasNext()){
        	Account account=a.next();
        	account.setPersonId(user.getPersonId());
        }
        Iterator<PracticesModel> p=user.getPractices().iterator();
        while(p.hasNext()){
        	PracticesModel practice=p.next();
        	practice.setPersonId(user.getPersonId());
        }
        Iterator<FunctionalityModel> f=user.getFunctions().iterator();
        while(p.hasNext()){
        	FunctionalityModel function=f.next();
        	function.setPersonId(user.getPersonId());
        }
        
        session.merge(user);
        
        session.getTransaction().commit(); 
        session.close();
    }
    public void saveDetails(ArrayList<FunctionalityModel> details,int personId) {
    	 if(details.isEmpty())
    		 return;
    	session = sessionCreator.openSession();
    	session.beginTransaction();
    	
    	Iterator<FunctionalityModel> it=details.iterator();
        while(it.hasNext()){
        	FunctionalityModel model=it.next();
        	session.save(model);
        }
        session.getTransaction().commit();    
        session.close();
    }
    public void savePractices(ArrayList<PracticesModel> practices,int personId) {
   	 if(practices.isEmpty())
   		 return;
   	session = SessionFactoryUtil.getSessionFactory().openSession();
   	session.beginTransaction();
   	
   	Iterator<PracticesModel> it=practices.iterator();
       while(it.hasNext()){
    	PracticesModel model=it.next();
       	session.save(model);
       }
       session.getTransaction().commit();   
       session.close();
   }
}
