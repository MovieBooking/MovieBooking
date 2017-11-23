/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import Class.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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
    
    
    private ArrayList<Theater> theat = new ArrayList<Theater>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        String size,Screen screen, String time, int id, String status
     
        Theater a1 = new Theater("Small",new Screen( "3D Screen", 1),"12.00",1,"SHOWING");
        Theater a2 = new Theater("Small",new Screen( "3D Screen", 2),"15.00",1,"SHOWING");
        Theater a3 = new Theater("Small",new Screen( "3D Screen", 3),"18.00",1,"SHOWING");
        
        Theater a4= new Theater("Medium",new Screen( "3D Screen", 4),"12.00",2,"SHOWING");
        Theater a5 = new Theater("Meduim",new Screen( "3D Screen", 5),"15.00",2,"SHOWING");
        Theater a6= new Theater("Large",new Screen( "3D Screen", 6),"12.00",3,"SHOWING");
        theat.add(a1);
        theat.add(a2);
        theat.add(a3);
        theat.add(a4);
        theat.add(a5);
        theat.add(a6);
       
        Movie movie = new Movie("Justice Leauge", 120, "Action", "2016-11-23", "imageurl", 20);
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
            name.setText("Dulation");
            name.setText("Status");
            
            
            temp.setLayoutX(X);
             temp.setLayoutY(Y+i*200);
            temp.getChildren().add(imageView);
            anchor.getChildren().add(temp);
            
            
            
            
            
            }
            
       
            {
                
            }
       
      
    }    
    
}
