/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import Class.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PysiAz
 */
public class TimetableController implements Initializable {
    
   
    @FXML
    private Pane backpane;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Pane normalpane;

    @FXML
    private Label name;

    @FXML
    private Label screen;

    @FXML
    private ImageView image;

    @FXML
    private Label dulation;

    @FXML
    private Button btn2;

    @FXML
    private Label status;

    @FXML
    private Label ID;

    @FXML
    private Button btn3;

    @FXML
    private Button btn1;
    private Theater theater;
    
//         ArrayList<Boolean> boolean_list = new ArrayList<Boolean>();
    
    
    private List<Theater> theat = new ArrayList<Theater>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//      
//     String size,Movie movie,Screen screen, String time, int id, String status)
        DataService dataService = new DataService();
        theat = dataService.getTheater(1);
       
        Movie movie = new Movie("Justice Leauge", 120, "Action", "2016-11-23", "imageurl", 20,"ENG");
                float X = 0;
                float Y = 0;
            int max = 0;
            for (Theater theater1 : theat) {
                if(theater1.getTheater_id() >= max)
                {
                   max =  theater1.getTheater_id();
                }
        
                System.out.println("max = "+max);
            }
            for (int i = 0; i < max; i++) {
             Pane temp = new Pane();
             
            Image image = new Image("/images/beyond-Skyline-poster.jpg",200,150,false,true);
            ImageView imageView = new ImageView(image);    
            imageView.setLayoutX(20);
            imageView.setLayoutX(40);
            
            Text name = new Text();
            Text screen = new Text();
            Text dulation = new Text();
            Text status = new Text();
            name.setText("Name");
            name.setText("screen");
            name.setText("Name");
            
            
            temp.setLayoutX(X);
             temp.setLayoutY(Y+i*200);
            temp.getChildren().add(imageView);
            anchor.getChildren().add(temp);
            
            
          
            
            }
            
       
            {
                
            }
       
      dataService.closeConnection();
    }    
    @FXML
    public void jump() throws IOException
    {
          try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Theater.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        
        TheaterController controller=fxmlLoader.<TheaterController>getController();
        controller.setUser(Integer.parseInt("3"));
        controller.setting();
        fxmlLoader.setController(controller);
        Stage stage = new Stage();
        stage.setTitle("Edytuj klienta");
        stage.setScene(new Scene(root1));
        stage.show();
         } catch(Exception e) {
        e.printStackTrace();
    }
//        primaryStage.setScene(scene);     
//
//        primaryStage.show();   
//            
           
    }
}
