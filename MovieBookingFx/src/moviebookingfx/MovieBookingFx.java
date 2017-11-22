/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author Sivakorn
 */
public class MovieBookingFx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
 
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Movie.odb");
//        EntityManager em = emf.createEntityManager();
//               em.getTransaction().begin();
//       
//        Movie movie2 = new Movie13Rating("Justice League", 120, "Action", "Nov 16,2017", "file:images/justice-league-poster.jpg");
//        em.persist(movie1);
//        em.persist(movie2);
//        em.getTransaction().commit();
//        em.clear();
  // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("database/Movie.odb");
        EntityManager em = emf.createEntityManager();
 
        // Store 1000 Point objects in the database:
//        em.getTransaction().begin();
//          Screen temp = new ImaxScreen(1);
//          em.persist(temp);   
//        Theater theater = new SmallTheater(temp, "11:00", 1,"SHOWING");
//        em.persist(theater);
//        em.getTransaction().commit();
//                em.getTransaction().begin();
//        for (Seats[] seat : theater.getSeats()) {
//            for (Seats seats : seat) {
//                em.persist(seats);
//            }
//        }
//           em.getTransaction().commit();
            TypedQuery<Theater> query = em.createQuery("SELECT Theater FROM Theater", Theater.class);
            List<Theater> results = query.getResultList();
            Theater x = results.get(0);
            System.out.println(x);
            em.close();
        emf.close();
    }
    
}
