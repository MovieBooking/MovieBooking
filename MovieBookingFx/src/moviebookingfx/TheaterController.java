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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author terkg
 */
public class TheaterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Button backbutton;

    @FXML
    private Button buybutton;

    @FXML
    private AnchorPane theaterpane;

    @FXML
    private AnchorPane ticketpane;

    int user_id;
    private DataService _dataService = new DataService();
    private Theater theater;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        
//        System.out.println("this user= "+this.user_id);
//      
//        this.theater = _dataService.getTheater(1).get(0);
//        System.out.println(theater);
//        float positionx = 117;
//        float positiony = 672;
//        for (List<Seats> seat : theater.getSeats()) {
//            for (Seats seats : seat) {
//                if (seats.getName().equals("Deluxe Seat")) {
//                    Button temp = new Button(seats.getPosition());
//                    temp.setLayoutX(positionx);
//                    temp.setLayoutY(positiony);
//                    temp.setMinSize(100, 30);
//                    positionx += 150;
//                    theaterpane.getChildren().add(temp);
//                } else {
//                    Button temp = new Button(seats.getPosition());
//                    temp.setLayoutX(positionx);
//                    temp.setLayoutY(positiony);
//                    temp.setMinSize(40, 30);
//                    positionx += 40;
//                    theaterpane.getChildren().add(temp);
//                }
//            }
//            if (seat.get(0).getName().equals("Deluxe Seat")) {
//                positiony = 596;
//            } else {
//                positiony -= 30;
//            }
//            positionx = 55;
//        }
    }

    @FXML
    public void testing(ActionEvent event) {
        System.out.println("xxxx");
    }
    
    public void setting(){
        
        System.out.println("this user= "+this.user_id);
      
        this.theater = _dataService.getTheater(user_id).get(0);
        System.out.println(theater);
        float positionx = 117;
        float positiony = 672;
        for (List<Seats> seat : theater.getSeats()) {
            for (Seats seats : seat) {
                if (seats.getName().equals("Deluxe Seat")) {
                    Button temp = new Button(seats.getPosition());
                    temp.setLayoutX(positionx);
                    temp.setLayoutY(positiony);
                    temp.setMinSize(100, 30);
                    positionx += 150;
                    theaterpane.getChildren().add(temp);
                } else {
                    Button temp = new Button(seats.getPosition());
                    temp.setLayoutX(positionx);
                    temp.setLayoutY(positiony);
                    temp.setMinSize(40, 30);
                    positionx += 40;
                    theaterpane.getChildren().add(temp);
                }
            }
            if (seat.get(0).getName().equals("Deluxe Seat")) {
                positiony = 596;
            } else {
                positiony -= 30;
            }
            positionx = 55;
        }
    }
    public void setUser(int user_id){
    this.user_id = user_id;
//     System.out.println("this user= "+this.user_id);
    
}

}
