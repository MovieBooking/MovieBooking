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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PysiAz
 */
public class TimetableController implements Initializable {

//    @FXML
//    private AnchorPane backpane;
//    
//    @FXML
//    private AnchorPane anchor_scroll;
//    
//    @FXML
//    private ScrollPane scrollpane;
//    
//    @FXML
//    private Button btn1;
    @FXML
    private AnchorPane backpane;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private AnchorPane anchor_scroll;

    @FXML
    private ScrollPane selectpane;

    @FXML
    private AnchorPane anchor_select;

    @FXML
    private ComboBox searchbox;

    @FXML
    private Button back;

    int theater_id;
    int theater_index;
    int image_x;
    int image_y;
    int right_grid_y;

    DataService dataService = new DataService();
  
    private List<Integer> theat_index = new ArrayList<Integer>();
    private List<Theater> theat = new ArrayList<Theater>();
    private List<Theater> right_theat = new ArrayList<Theater>();
    private List<Pane> movies = new ArrayList<Pane>();
    private List<Movie> selectMovie = new ArrayList<Movie>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        //left pane

        GridPane gridpane = new GridPane();
        gridpane.setMinSize(570, 250);
        gridpane.setHgap(100);
        gridpane.getColumnConstraints().add(new ColumnConstraints(570));
        scrollpane.setContent(gridpane);

        for (int i = 1; i < 11; i++) {
            theat = dataService.getTheater(i);
            movies.add(createPane(theat, i - 1));
            gridpane.add(movies.get(i - 1), 0, i - 1);
        }

//         right pane
         GridPane gridpane2 = new GridPane();
        gridpane2.setMinSize(570, 250);
        gridpane2.setHgap(100);
        gridpane2.getColumnConstraints().add(new ColumnConstraints(570));
        selectpane.setContent(gridpane2);
        selectMovie = dataService.getAllMovie();
        searchbox.getItems().clear();

        for (Movie movie : selectMovie) {
            if (!movie.getTheater().isEmpty()) {     
                int temp = movie.getTheater().get(0).getId();
                searchbox.getItems().add(movie.getName() + "(" + movie.getLanguage() + ")");
            } 
          
        }

        searchbox.valueProperty().addListener(new ChangeListener<String>() {

            @Override

            public void changed(ObservableValue ov, String t, String t1) {
                while (gridpane2.getChildren().size() > 0) {
                    gridpane2.getChildren().remove(gridpane2.getChildren().size() - 1);

                }

                int index = 0;
                for (int i = 0; i < selectMovie.size(); i++) {

                    if (searchbox.getValue().equals(selectMovie.get(i).getName() + "(" + selectMovie.get(i).getLanguage() + ")")) {

                        int temp = selectMovie.get(i).getTheater().get(0).getTheater_id();
                        for (int j = 0; j < selectMovie.get(i).getTheater().size(); j++) {
                            if (selectMovie.get(i).getTheater().get(j).getTheater_id() != temp || j == selectMovie.get(i).getTheater().size() - 1) {

//                                 gridpane2.add(createMovie1(selectMovie.get(i).getTheater()), 0, index);
                                gridpane2.add(createMovie1(right_theat), 0, index);
                                while (right_theat.size() > 0) {
                                    right_theat.remove(right_theat.size() - 1);
                                }

                                index++;
                            } else {
                                right_theat.add(selectMovie.get(i).getTheater().get(j));

                            }
                            temp = selectMovie.get(i).getTheater().get(j).getTheater_id();
                        }
                    }
                }

            }
        });

        dataService.closeConnection();

    }

    //here
    public Pane createMovie1(List<Theater> theat) {

        Pane pane = new Pane();
        pane.minHeight(250);
        pane.minWidth(570);
        pane.setStyle("-fx-border-color:red;");
        pane.setPadding(new Insets(8));

        Label text = new Label("THETHER " + (theat.get(0).getTheater_id()) + "  SCREEN : " + theat.get(0).getScreen().getName());
        text.setLayoutX(30);
        text.setLayoutY(10);
        
        Label name = new Label("NAME: " + searchbox.getValue());
        name.setLayoutX(125);
        name.setLayoutY(40);

        Label length = new Label("DURATION: " + String.valueOf(theat.get(0).getMovie().getLength()));
        length.setLayoutX(125);
        length.setLayoutY(70);

        Label ratename = new Label("RATE: " + theat.get(0).getMovie().getRatename());
        ratename.setLayoutX(125);
        ratename.setLayoutY(100);

        Label genre = new Label("GENRE: " + theat.get(0).getMovie().getGenre());
        genre.setLayoutX(350);
        genre.setLayoutY(70);

        Label language = new Label("LANGUAGE: " + theat.get(0).getMovie().getLanguage());
        language.setLayoutX(350);
        language.setLayoutY(40);

        Label time = new Label("TIME: ");
        time.setLayoutX(125);
        time.setLayoutY(130);

        Image image = new Image(theat.get(0).getMovie().getImage(), 100, 150, false, true);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(13);
        imageView.setLayoutY(39);

        theater_index = 0;
        int X = 0;
        for (Theater theater1 : theat) {

            theat_index.add(theater_index);

            Button btn = new Button(theater1.getTime());
            btn.setLayoutX(210 + X);
            btn.setLayoutY(130);
            pane.getChildren().add(btn);

            if (theater1.getStatus().contains("SHOWING")) {
                btn.setStyle("-fx-border-color:blue");
                btn.setStyle("-fx-background-color:#00FF00");

                btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        theater_index = theat_index.get(theater1.getId() - 1);
                        theater_id = theater1.getTheater_id();

//                 jump to another class
                        try {
                            jump();
                        } catch (IOException ex) {
                            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } else if (theater1.getStatus().contains("DONE")) {
                btn.setStyle("-fx-border-color:red");
                btn.setStyle("-fx-background-color:gray");

            }

            theater_index++;

            X += 70;

        }

        pane.getChildren().addAll(text,name, length, ratename, genre, language, time, imageView);
        return pane;
    }

    public Pane createPane(List<Theater> theat, int index) {
        Pane pane = new Pane();
        pane.minHeight(100);
        pane.minWidth(570);
        pane.setStyle("-fx-border-color:red;");
        pane.setPadding(new Insets(8));

        Label text = new Label("THETHER " + (index + 1) + "  SCREEN : " + theat.get(0).getScreen().getName());
        text.setLayoutX(30);
        text.setLayoutY(10);

        Label name = new Label("NAME: " + theat.get(0).getMovie().getName());
        name.setLayoutX(125);
        name.setLayoutY(40);

        Label length = new Label("DURATION: " + String.valueOf(theat.get(0).getMovie().getLength()));
        length.setLayoutX(125);
        length.setLayoutY(70);

        Label ratename = new Label("RATE: " + theat.get(0).getMovie().getRatename());
        ratename.setLayoutX(125);
        ratename.setLayoutY(100);

        Label genre = new Label("GENRE: " + theat.get(0).getMovie().getGenre());
        genre.setLayoutX(300);
        genre.setLayoutY(70);

        Label language = new Label("LANGUAGE: " + theat.get(0).getMovie().getLanguage());
        language.setLayoutX(300);
        language.setLayoutY(40);

        Label time = new Label("TIME: ");
        time.setLayoutX(125);
        time.setLayoutY(130);

        Image image = new Image(theat.get(0).getMovie().getImage(), 100, 150, false, true);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(13);
        imageView.setLayoutY(39);

        theater_index = 0;
        int X = 0;
        int Y = 0;
        List<Button> temp = new ArrayList<Button>();
        for (Theater theater1 : theat) {

            theat_index.add(theater_index);
            if(X >=280)
            {
                X = 0;
                Y += 45;
            }
            temp.add( new Button(theater1.getTime()));
            temp.get(temp.size()-1).setLayoutX(210+X);
            temp.get(temp.size()-1).setLayoutY(130+Y);
            pane.getChildren().add(temp.get(temp.size()-1));
            
//            Button btn = new Button(theater1.getTime());
//            btn.setLayoutX(210 + X);
//            btn.setLayoutY(130 + Y);
//            pane.getChildren().add(btn);
           

            if (theater1.getStatus().contains("SHOWING")) {
                temp.get(temp.size()-1).setStyle("-fx-border-color:blue");
                temp.get(temp.size()-1).setStyle("-fx-background-color:#00FF00");
                temp.get(temp.size()-1).setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        for (Button button : temp) {
                            if(button.getText().equals(theater1.getTime())){
                              
                                theater_index = temp.indexOf(button);
                            }
                        }
//                        theater_index = theat_index.get(theater1.getId() - 1);
                        theater_id = theater1.getTheater_id();

//                 jump to another class
                        try {
                            jump();
                        } catch (IOException ex) {
                            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } else if (theater1.getStatus().contains("DONE")) {
                
                 temp.get(temp.size()-1).setStyle("-fx-border-color:red");
                temp.get(temp.size()-1).setStyle("-fx-background-color:gray");
                

            }

            theater_index++;

            X += 70;
        }

        pane.getChildren().addAll(text, name, length, ratename, genre, language, imageView, time);

        return pane;
    }

    @FXML
    //cant take parametre in this method
    public void jump() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Theater.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        TheaterController controller = fxmlLoader.<TheaterController>getController();
        controller.setTheaterID(theater_id, theater_index);
        fxmlLoader.setController(controller);
        backpane.getChildren().setAll(root);

    }
      @FXML
    //cant take parametre in this method
    public void back() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        MenuController controller = fxmlLoader.<MenuController>getController();
        fxmlLoader.setController(controller);
        backpane.getChildren().setAll(root);

    }
}
