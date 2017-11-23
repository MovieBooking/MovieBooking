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
        DataService _dataService = new DataService();
//        em.getTransaction().begin();
//        Theater theater = new SmallTheater(new ImaxScreen(1), "11:00", 1,"SHOWING");
//            em.persist(theater);
//            em.getTransaction().commit();
        
        _dataService.createTheater(new MediumTheater(new ImaxScreen(1), "11.00", 1, "AVALIABLE"));
       _dataService.createTheater(new MediumTheater(_dataService.getScreen(1), "13.00", 1, "AVALIABLE"));
        //Theater x1 = _dataService.getTheater(1);
       // Theater
       
       
       
        //x2 = _dataService.getTheater(2);
        //Screen y1 = _dataService.getScreen(1);
       // System.out.println(x1.toString());
      // System.out.println(x2.toString());
        //System.out.println(y1.toString());
        

        _dataService.closeConnection();
    }
}
