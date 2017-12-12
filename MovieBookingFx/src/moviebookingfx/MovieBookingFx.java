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



        Parent root = FXMLLoader.load(getClass().getResource("Timetable.fxml"));



        primaryStage.setTitle("MOVIE");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        DataService dataService = new DataService();
        
        //dataService.createPromotion(new Promotion("BOXOFFICE", "00000001", "09/12/2019", 5));
        dataService.closeConnection();
        
        launch(args);
    }

}
