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

        Parent root = FXMLLoader.load(getClass().getResource("Theater.fxml"));
        primaryStage.setTitle("HELLO world");
        primaryStage.setScene(new Scene(root, 1200, 800));
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
//        dataService.createMovie(new Movie("Beyond Skyline", 105, "ACTION/THRILLER", "21 NOV 2017", "/images/beyond-Skyline-poster.jpg", 15, "EN-TH"));
//        dataService.createMovie(new Movie("Beyond Skyline", 105, "ACTION/THRILLER", "21 NOV 2017", "/images/beyond-Skyline-poster.jpg", 15, "TH"));
//        dataService.createMovie(new Movie("Wonder", 113, "LIFE", "7 DEC 2017", "/images/wonder-poster.jpg", 0, "EN-TH"));
//        dataService.createMovie(new Movie("Wonder", 113, "LIFE", "7 DEC 2017", "/images/wonder-poster.jpg", 0, "TH"));
//        dataService.createMovie(new Movie("Star War 8", 150, "ACTION/ADVENTURE", "11 DEC 2017", "/images/star-wars-8-poster.jpg", 13, "EN-TH"));
//        dataService.createMovie(new Movie("Star War 8", 150, "ACTION/ADVENTURE", "11 DEC 2017", "/images/star-wars-8-poster.jpg", 13, "TH"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Wonder", "TH"), new Screen("2D", 1), "11:00", 1, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Wonder", "TH"), dataService.getScreen(1), "13:30", 1, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Wonder", "TH"), dataService.getScreen(1), "16:00", 1, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Wonder", "TH"), dataService.getScreen(1), "21:30", 1, "SHOWING"));
//
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Wonder", "EN-TH"), new Screen("2D", 2), "12:00", 2, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Wonder", "EN-TH"), dataService.getScreen(2), "14:30", 2, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Wonder", "EN-TH"), dataService.getScreen(2), "17:30", 2, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Wonder", "EN-TH"), dataService.getScreen(2), "21:10", 2, "SHOWING"));
//
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Beyond Skyline", "TH"), new Screen("2D", 3), "11:00", 3, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Beyond Skyline", "TH"), dataService.getScreen(3), "14:30", 3, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Beyond Skyline", "TH"), dataService.getScreen(3), "18:00", 3, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Beyond Skyline", "TH"), dataService.getScreen(3), "21:30", 3, "SHOWING"));
//
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "TH"), new Screen("3D", 7), "12:40", 7, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "TH"), dataService.getScreen(7), "16:10", 7, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "TH"), dataService.getScreen(7), "19:40", 7, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "TH"), dataService.getScreen(7), "23:10", 7, "SHOWING"));
//
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Star War 8", "EN-TH"), new Screen("Imax", 8), "10:20", 8, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(8), "13:20", 8, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(8), "16:20", 8, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(8), "19:20", 8, "SHOWING"));
//        
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Star War 8", "EN-TH"), new Screen("Ultra", 9), "11:30", 9, "SHOWING"));
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(9), "17:00", 9, "SHOWING"));
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(9), "21:00", 9, "SHOWING"));
//
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Justice League", "EN-TH"), new Screen("4D", 10), "12:30", 10, "SHOWING"));
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Justice League", "EN-TH"), dataService.getScreen(10), "16:00", 10, "SHOWING"));
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Justice League", "EN-TH"), dataService.getScreen(10), "21:00", 10, "SHOWING"));
//        
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Beyond Skyline", "EN-TH"), new Screen("3D", 4), "10:10", 4, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Beyond Skyline", "EN-TH"), dataService.getScreen(4), "13:30", 4, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Beyond Skyline", "EN-TH"), dataService.getScreen(4), "17:00", 4, "SHOWING"));
//        dataService.createTheater(new Theater("Small", dataService.getMovie("Beyond Skyline", "EN-TH"), dataService.getScreen(4), "20:30", 4, "SHOWING"));
//
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Beyond Skyline", "EN-TH"), new Screen("3D", 5), "11:30", 5, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Beyond Skyline", "EN-TH"), dataService.getScreen(5), "16:30", 5, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Beyond Skyline", "EN-TH"), dataService.getScreen(5), "20:30", 5, "SHOWING"));
//
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "EN-TH"), new Screen("3D", 6), "12:30", 6, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "EN-TH"), dataService.getScreen(6), "16:00", 6, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "EN-TH"), dataService.getScreen(6), "19:30", 6, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "EN-TH"), dataService.getScreen(6), "23:00", 6, "SHOWING"));
//
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "TH"), new Screen("3D", 7), "12:40", 7, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "TH"), dataService.getScreen(7), "16:10", 7, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "TH"), dataService.getScreen(7), "19:40", 7, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Justice League", "TH"), dataService.getScreen(7), "23:10", 7, "SHOWING"));
//
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Star War 8", "EN-TH"), new Screen("Imax", 8), "10:20", 8, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(8), "13:20", 8, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(8), "16:20", 8, "SHOWING"));
//        dataService.createTheater(new Theater("Medium", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(8), "19:20", 8, "SHOWING"));
//        
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Star War 8", "EN-TH"), new Screen("Ultra", 9), "11:30", 9, "SHOWING"));
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(9), "17:00", 9, "SHOWING"));
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Star War 8", "EN-TH"), dataService.getScreen(9), "21:00", 9, "SHOWING"));
//
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Justice League", "EN-TH"), new Screen("4D", 10), "12:30", 10, "SHOWING"));
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Justice League", "EN-TH"), dataService.getScreen(10), "16:00", 10, "SHOWING"));
//        dataService.createTheater(new Theater("Large", dataService.getMovie("Justice League", "EN-TH"), dataService.getScreen(10), "21:00", 10, "SHOWING"));
//        
        dataService.closeConnection();
        launch(args);
    }

}
