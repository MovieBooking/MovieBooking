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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.*;
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
    private SplitPane Splitpane;
    
    @FXML
    private Button backbutton;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private Button buybutton;

    @FXML
    private AnchorPane theaterpane;

    @FXML
    private AnchorPane ticketpane;
    
    @FXML
    private Label cost;
    
    int theater_id;
    int ticket_id;
    private DataService _dataService = new DataService();
    private Theater theater;
    private List<Pane> ticket = new ArrayList<Pane>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public Pane createPane(String name, String position, int cost, String time, String seat) {
        cost += theater.getScreen().getPrice();
        Pane pane = new Pane();
        pane.minHeight(150);
        pane.minWidth(229);
        pane.setStyle("-fx-border-color:red;");
        pane.setPadding(new Insets(8));
        Label name_label = new Label(name);
        name_label.setLayoutX(13);
        name_label.setLayoutY(13);
        Label position_label = new Label("Seat : " + position);
        position_label.setLayoutY(26);
        position_label.setLayoutX(50);
        position_label.setStyle("-fx-font-size:25px;");
        Label time_label = new Label("Time:" + time);
        time_label.setLayoutX(150);
        time_label.setLayoutY(13);
        Label cost_label = new Label("Cost:" + cost);
        cost_label.setLayoutX(150);
        cost_label.setLayoutY(58);
        Label seat_label = new Label(seat);
        seat_label.setLayoutX(13);
        seat_label.setLayoutY(58);
        pane.getChildren().addAll(seat_label, name_label, position_label, time_label, cost_label);
        pane.setId(position);
        return pane;
    }

    @FXML
    public void confirm(ActionEvent event) {
        _dataService.transactionBegin();
        for (Pane pane : ticket) {
            for (List<Seats> seat : theater.getSeats()) {
                for (Seats seats : seat) {
                    if (pane.getId().equals(seats.getPosition())) {
                        seats.setIsBook(true);
                    }
                }
            }
        }
        _dataService.transactionCommit();
    }

    @FXML
    public void back(ActionEvent event) throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Timetable.fxml"));
        Parent root = (Parent) fxmlLoader.load(); 
        Splitpane.getItems().setAll(root);
        
        
        
        System.out.println("xxxx");
    }
    
    @FXML
    public void setTheaterID(int theater_id,int theater_index)
    {
//        this.theater_id = theater_id;
        System.out.println("here is theter theater_id (receive) = "+theater_id);
        System.out.println("here is theter theater_index (receive) = "+theater_index);
        
        ticket_id = 0;
        
        
        
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-border-color:blue;");
        gridpane.setMinSize(229, 630);
        gridpane.setHgap(100);
        gridpane.getColumnConstraints().add(new ColumnConstraints(228));
        scrollpane.setContent(gridpane);

        List<Button> temp = new ArrayList<Button>();
        this.theater = _dataService.getTheater(theater_id).get(theater_index);
        
        Label label = new Label(String.format("THEATER: %d\nMOVIE : %s\nTIME: %s\n",theater_id ,theater.getMovie().getName(),theater.getTime() ));
        label.setLayoutX(200);
        label.setLayoutY(20);
        theaterpane.getChildren().add(label);
       
        System.out.println(theater);
        float positionx = 117;
        float positiony = 672;
        String styleH = "-fx-background-color:blue;-fx-text-fill:white;-fx-border-color:black";
        String styleD = "-fx-background-color:pink;-fx-text-fill:black;-fx-border-color:black";
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

                                        for (int i = 0; i < ticket.size(); i++) {
                                            if (ticket.get(i).getId().equals(seats.getPosition())) {
                                                ticket_id--;
                                                cost.setText(""+(Integer.parseInt(cost.getText())-seats.getPrice()-theater.getScreen().getPrice()));
                                                gridpane.getChildren().remove(ticket.get(i));
                                                ticket.remove(i);
                                            }
                                        }
                                    } else {
                                        button.setStyle(stylep);
                                        cost.setText(""+(Integer.parseInt(cost.getText())+seats.getPrice()+theater.getScreen().getPrice()));
                                        ticket.add(createPane(theater.getMovie().getName(), seats.getPosition(), seats.getPrice(), theater.getTime(), seats.getName()));
                                        gridpane.add(ticket.get(ticket.size() - 1), 0, ticket_id);
                                        System.out.println(seats);
                                        ticket_id++;
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

            if (seat.get(0).getName().equals("Deluxe Seat")) {
                positiony = 596;
            } else {
                positiony -= 30;
            }
            positionx = 55;
        }
    }

}
