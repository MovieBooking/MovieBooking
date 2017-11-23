package moviebookingfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Class.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sivakorn
 */
public class MovieBookingFx extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("timetable.fxml"));
        primaryStage.setTitle("HELLO world");
        primaryStage.setScene(new Scene(root,1200,800));
        primaryStage.show();
        
        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
// 
//            }
//        });
//           
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//      
//            Parent root = FXMLLoader.load(getClass().getResource("FXML_seats.fxml"));
//            primaryStage.setTitle("HELLO world");
//            primaryStage.setScene(new Scene(root,800,500));
//            primaryStage.show();
//

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataService dataService = new DataService();
//        dataService.createMovie(new Movie("Justice League", 180, "ACTION", "16 NOV 2017", "/images/justice-league-poster.jpg", 13, "EN-TH"));
//        dataService.createMovie(new Movie("Justice League", 180, "ACTION", "16 NOV 2017", "/images/justice-league-poster.jpg", 13, "TH"));
//        
//        dataService.createTheater(new Theater("Small",dataService.getMovie("Justice League","TH"),new Screen("3D",1), "11:00", 1, "SHOWING"));
//        dataService.createTheater(new Theater("Medium",dataService.getMovie("Justice League","TH"),new Screen("Ultra",2), "11:00", 2, "SHOWING"));
//        dataService.createTheater(new Theater("Large",dataService.getMovie("Justice League","EN-TH"),new Screen("Imax",3), "11:00", 3, "SHOWING"));
        dataService.closeConnection();
        launch(args);
    }
    
}
