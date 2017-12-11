/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Better
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button Booking;

    @FXML
    private Button Manage_Theater;

    @FXML
    private AnchorPane backpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Booking.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

//                 jump to another class
                try {
                    jumpTimetable();
                } catch (IOException ex) {
                    Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        Manage_Theater.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

//                 jump to another class
                try {
                    jumpManage();
                } catch (IOException ex) {
                    Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

   
    public void jumpManage() throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageMovie.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        TheaterController controller = fxmlLoader.<TheaterController>getController();
//        controller.setTheaterID(Integer.parseInt(id));

//        controller.setting();
        fxmlLoader.setController(controller);

        backpane.getChildren().setAll(root);
//            
    }

    
    public void jumpTimetable() throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Timetable.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        TheaterController controller = fxmlLoader.<TheaterController>getController();
//        controller.setTheaterID(Integer.parseInt(id));
//        controller.setting();
        fxmlLoader.setController(controller);

        backpane.getChildren().setAll(root);

//        
//        Stage stage = new Stage();
//        stage.setTitle("theater");
//        stage.setScene(new Scene(root));
//        stage.show();
//            
    }

}
