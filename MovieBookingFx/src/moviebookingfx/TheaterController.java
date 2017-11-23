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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    private DataService _dataService = new DataService();
    private Theater theater;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Image img = new Image("images/justice-league-poster.jpg",50,50,false,true);
//        ImageView imgView = new ImageView(img);
//        theaterpane.getChildren().add(imgView);
       
        List<Button> temp = new ArrayList<Button>();
        this.theater = _dataService.getTheater(3).get(0);
        
        System.out.println(theater);
        float positionx = 117;
        float positiony = 672;
        String styleH = "-fx-background-color:blue;-fx-text-fill:white;-fx-border-color:black";
        String styleD = "-fx-background-color:pink;-fx-text-fill:white;-fx-border-color:black";
        String styleN = "-fx-background-color:red;-fx-text-fill:white;-fx-border-color:black";
        String stylep = "-fx-background-color:#6fff43;-fx-text-fill:white;-fx-border-color:black";
        for (List<Seats> seat : theater.getSeats()) {
            for (Seats seats : seat) {
                temp.add(new Button(seats.getPosition()));
                if (seats.getIsBook() == true) {
                    temp.get(temp.size() - 1).setStyle("-fx-background-color:gray;-fx-text-fill:black;-fx-border-color:black");
                } else {

                    if (seats.getName().equals("Normal Seat")) {
                        temp.get(temp.size() - 1).setStyle(styleN);
                    } else if (seats.getName().equals("Deluxe Seat")) {
                        temp.get(temp.size() - 1).setStyle(styleD);
                    } else {
                        temp.get(temp.size() - 1).setStyle(styleH);
                    }
                    temp.get(temp.size() - 1).setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            for (Button button : temp) {
                                if (button.getText().equals(seats.getPosition())) {
                                    if (button.getStyle().equals(stylep)) {
                                        if (seats.getName().equals("Normal Seat")) {
                                            button.setStyle(styleN);
                                        } else if (seats.getName().equals("Deluxe Seat")) {
                                            button.setStyle(styleD);
                                        } else {
                                            button.setStyle(styleH);
                                        }
                                    } else {
                                        button.setStyle(stylep);
                                        
                                        System.out.println(seats);
                                    }
                                }
                            }
                        }
                    }
                    );
                }
                temp.get(temp.size() - 1).setLayoutX(positionx);
                temp.get(temp.size() - 1).setLayoutY(positiony);
                temp.get(temp.size() - 1).setLayoutX(positionx);
                temp.get(temp.size() - 1).setLayoutY(positiony);
                if (seats.getName().equals("Deluxe Seat")) {
                    temp.get(temp.size() - 1).setMinSize(100, 30);
                    positionx += 150;
                } else {
                    temp.get(temp.size() - 1).setMinSize(42, 29);
                    positionx += 42;
                }

                theaterpane.getChildren().add(temp.get(temp.size() - 1));

            }

            if (seat.get(
                    0).getName().equals("Deluxe Seat")) {
                positiony = 596;
            } else {
                positiony -= 30;
            }
            positionx = 55;
        }
    }

    @FXML
    public void testing(ActionEvent event
    ) {
        System.out.println("xxxx");
    }

}
