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
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

/**
 *
 * @author Sivakorn
 */
public class ManageMovieControlller implements Initializable {

    @FXML
    private AnchorPane showingpane;

    @FXML
    private AnchorPane manage;
    
    @FXML
    private ScrollPane scrollpane;

    private List<Pane> cinema = new ArrayList<Pane>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-border-color:blue;");
        gridpane.setMinSize(229, 630);
        gridpane.setHgap(100);

        gridpane.getColumnConstraints().add(new ColumnConstraints(228));

    }

    public Pane createPane(Theater theater, Movie movie) {
        Pane pane = new Pane();
//        pane.minHeight(150);
//        pane.minWidth(229);
//        pane.setStyle("-fx-border-color:red;");
//        pane.setPadding(new Insets(8));
//        Label name_label = new Label(name);
//        name_label.setLayoutX(13);
//        name_label.setLayoutY(13);
//        Label position_label = new Label("Seat : " + position);
//        position_label.setLayoutY(26);
//        position_label.setLayoutX(50);
//        position_label.setStyle("-fx-font-size:25px;");
//        Label time_label = new Label("Time:" + time);
//        time_label.setLayoutX(150);
//        time_label.setLayoutY(13);
//        Label cost_label = new Label("Cost:" + cost);
//        cost_label.setLayoutX(150);
//        cost_label.setLayoutY(58);
//        Label seat_label = new Label(seat);
//        seat_label.setLayoutX(13);
//        seat_label.setLayoutY(58);
//        pane.getChildren().addAll(seat_label, name_label, position_label, time_label, cost_label);
//        pane.setId(position);
        return pane;
    }
}
