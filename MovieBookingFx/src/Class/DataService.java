/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import javax.persistence.*;

/**
 *
 * @author terkg
 */
public class DataService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("database/Movie.odb");
    private EntityManager em;

    public DataService() {
        this.emf = Persistence.createEntityManagerFactory("database/Movie.odb");
        this.em = emf.createEntityManager();
        System.out.println("DataBase is Connecting..");
    }

    public void createTheater(Theater theater) {
        this.em.getTransaction().begin();
        this.em.persist(theater);
        this.em.getTransaction().commit();
    }
    
    public void closeConnection() {
        this.em.close();
        this.emf.close();
    }
    
    public void transactionBegin(){
        this.em.getTransaction().begin();
    }
    
    public void transactionCommit(){
        this.em.getTransaction().commit();
    }
    
    public Theater getTheater(int id) {
        return em.find(Theater.class, id);  
    }
    
    public Screen getScreen(int id){
        return em.find(Screen.class,id);
    }
    public void deleteTheater(int id) {
        this.transactionBegin();
        this.em.remove(this.em.find(Theater.class, id));  
        this.transactionCommit();
    }
}
