/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import Class.*;
import com.objectdb.o.MSS;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private DataService _dataService = new DataService();
    private List<List<Theater>> theater = new ArrayList<List<Theater>>();
    private List<Pane> ticket = new ArrayList<Pane>();
    private List<Movie> movie = new ArrayList<Movie>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        movie = _dataService.getAllMovie();
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-border-color:blue;");
        gridpane.setMinSize(229, 630);
        gridpane.setHgap(100);
        gridpane.getColumnConstraints().add(new ColumnConstraints(600));
        scrollpane.setContent(gridpane);
        for (int i = 1; i < 11; i++) {
            theater.add(_dataService.getTheater(i));
            cinema.add(createPane(theater.get(i - 1)));
            gridpane.add(cinema.get(cinema.size() - 1), 0, i - 1);
        }

    }

    public Pane createPane(List<Theater> theater) {
        Pane pane = new Pane();
        pane.minHeight(100);
        pane.minWidth(600);
        pane.setStyle("-fx-border-color:red;");
        pane.setPadding(new Insets(8));
        Label movie_label = new Label(String.format("MOVIE : %-20s DURATION : %-20d LANGUAGE : %-20s\nGENRE: %-20s RATE: %-20s RELEASEDATE : %-20s", theater.get(0).getMovie().getName(), theater.get(0).getMovie().getLength(), theater.get(0).getMovie().getLanguage(), theater.get(0).getMovie().getGenre(), theater.get(0).getMovie().getRatename(), theater.get(0).getMovie().getReleaseDate()));

        Label theater_label = new Label(String.format("THEATER %2d %s", theater.get(0).getTheater_id(), theater.get(0).getScreen().getName()));
        theater_label.setLayoutX(200);
        theater_label.setLayoutY(5);
        theater_label.setStyle("-fx-font-size:25px;");
        Image image = new Image(theater.get(0).getMovie().getImage(), 100, 150, false, true);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(13);
        imageView.setLayoutY(39);

        for (Theater theater1 : theater) {
            movie_label = new Label(String.format("%s \nTime : %-20s Status :%-20s", movie_label.getText(), theater1.getTime(), theater1.getStatus()));
        }
        movie_label.setLayoutX(126);
        movie_label.setLayoutY(48);
        Button btn = new Button("MANANGE >>");
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingplan(theater.get(0).getTheater_id()-1);
            }
        });
        btn.setLayoutX(475);
        btn.setLayoutY(160);
        pane.getChildren().addAll(movie_label, theater_label, imageView, btn);
        pane.setId("" + theater.get(0).getTheater_id());
        return pane;
    }

    public void settingplan(int theater_id) {
        ComboBox movieselector = new ComboBox();
        for (Movie movie1 : movie) {
             movieselector.getItems().add((movie1.getName()+"("+movie1.getLanguage()+")"));
//             if(movie1.equals(theater.get(theater_id).get(0).getMovie()))
//                 movieselector.getSelectionModel().select();
        }
        
        movieselector.setLayoutX(20);
        movieselector.setLayoutY(20);
        Label m_label = new Label();
        m_label.setText("ChoseMovie");
        manage.getChildren().add(movieselector);
    }
}
