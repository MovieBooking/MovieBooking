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
    private Button booking;

    @FXML
    private Button manage_Theater;

    @FXML
    private AnchorPane backpane;

    @FXML
    private Button show_report;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

   @FXML
    public void jumpManageTheater() throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageMovie.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        ManageMovieControlller controller = fxmlLoader.<ManageMovieControlller>getController();
//        controller.setTheaterID(Integer.parseInt(id));

//        controller.setting();
        fxmlLoader.setController(controller);

        backpane.getChildren().setAll(root);
//            
    }

    @FXML
    public void jumpTimetable() throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Timetable.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        TimetableController controller = fxmlLoader.<TimetableController>getController();
        fxmlLoader.setController(controller);

        backpane.getChildren().setAll(root);
          
    }
    
     @FXML
     public void jumpManageAccount() throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageAccount.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ManageAccountController controller = fxmlLoader.<ManageAccountController>getController();
        fxmlLoader.setController(controller);

        backpane.getChildren().setAll(root);
//            
    }
  

}
