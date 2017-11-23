/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.List;
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
    
    public void createMovie(Movie movie) {
        this.em.getTransaction().begin();
        this.em.persist(movie);
        this.em.getTransaction().commit();
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
    public Movie getMovie(String name,String language) {
        String sql = "SELECT c FROM Movie c Where c.name = '"+name+"' AND c.language = +'"+language+"'";
        TypedQuery<Movie> query =  em.createQuery(sql, Movie.class);
        List<Movie> results = query.getResultList();    
        return results.get(0);
    }
    
    public List<Theater> getTheater(int id) {
        String sql = "SELECT c FROM Theater c Where c.theater_id ="+id+"";
        TypedQuery<Theater> query =  em.createQuery(sql, Theater.class);
        List<Theater> results = query.getResultList();    
        return results;
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
