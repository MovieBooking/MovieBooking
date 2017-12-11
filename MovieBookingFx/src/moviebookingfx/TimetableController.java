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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    int theater_id;
    int theater_index;
    int image_x;
    int image_y;
    int right_grid_y;
    
    DataService dataService = new DataService();
    GridPane gridpane2 = new GridPane();
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
        gridpane.setStyle("-fx-border-color:blue");
        gridpane.setMinSize(570, 250);
        gridpane.setHgap(100);
        gridpane.getColumnConstraints().add(new ColumnConstraints(570));
        scrollpane.setContent(gridpane);

      

        for (int i = 1; i < 11; i++) {
            theat = dataService.getTheater(i);
            movies.add(createPane(theat, i - 1));
            gridpane.add(movies.get(i - 1), 0, i - 1);
            System.out.println(i);
        }

//         right pane
    
        gridpane2.setStyle("-fx-border-color:blue");
        gridpane2.setMinSize(570, 250);
        gridpane2.setHgap(100);
        gridpane2.getColumnConstraints().add(new ColumnConstraints(570));
        selectpane.setContent(gridpane2);
        
        AnchorPane movielistpane = new AnchorPane();
        gridpane2.add(movielistpane, 0, 0);
         
        selectMovie = dataService.getAllMovie();
        String temp = "";
        image_x = 0;
        int count =0;
        for (int i = 0; i < selectMovie.size(); i++) {
             System.out.println("000000000000"+selectMovie.get(i).getName());
            System.out.println("11111111111"+selectMovie.get(i).getTheater());
            if ((!selectMovie.get(i).getName().equals(temp))&&(count !=0) || i==selectMovie.size()-1) {
                if(i == selectMovie.size()-1)
                    System.out.println("GG");
                movielistpane.getChildren().add(createMovie((i-count),count));
                image_x += 110;
                count =1;
                
            }
            else
            {
                count++;
            }
            System.out.println("22222222"+selectMovie.get(i).getName());
            temp = selectMovie.get(i).getName();
            
            
            
        }

        dataService.closeConnection();

    }

    public ImageView createMovie(int i,int count) {
       
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("333333333HERE"+i+count);
        Image image = new Image(selectMovie.get(i).getImage(), 100, 150, false, true);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(13 + image_x);
        imageView.setLayoutY(39 + image_y);
        
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
               while(gridpane2.getChildren().size() > 1){
                 gridpane2.getChildren().remove(gridpane2.getChildren().size()-1);
                 
                    }
              
                int index =1;
                for (int j = 0; j < count; j++) {
                       DataService dataService = new DataService();
                       System.out.println("SELECTMOVIE THEATER ID = "+selectMovie.get(i+j).getTheater().get(0).getTheater_id());
                       
                    for (int k = 0; k < selectMovie.get(i+j).getTheater().size()-1; k++) {
                         int temp =selectMovie.get(i+j).getTheater().get(k+1).getTheater_id();
                        if(temp != selectMovie.get(i+j).getTheater().get(k).getTheater_id() || k == selectMovie.get(i+j).getTheater().size()-2)
                        {
                          right_theat = dataService.getTheater(selectMovie.get(i+j).getTheater().get(k).getTheater_id());                 
                         System.out.println("RIGHT THEAT = "+right_theat);                             
                         gridpane2.add(createRightMovie(i), 0, index);
                          index++;                       
                         
                        }
                       
//                        System.out.println(selectMovie.get(i+next).getTheater().get(k).getTheater_id());
                        
                    }
                     
                                    
                }
                System.out.println("------------------");
                              
            }
            
        });
      
        if (image_x >= 550) {
            image_x = 0;
            image_y += 160;
        }
       

        return imageView;
    }
    
    public Pane createRightMovie(int i)
    {
        Pane pane = new Pane();
        pane.minHeight(100);
        pane.minWidth(570);
        pane.setStyle("-fx-border-color:red;");
        pane.setPadding(new Insets(8));
        
        Label name = new Label("NAME: " + right_theat.get(0).getMovie().getName());
        name.setLayoutX(125);
        name.setLayoutY(40);
        
        Image image = new Image(selectMovie.get(i).getImage(), 100, 150, false, true);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(13);
        imageView.setLayoutY(39);
        
        pane.getChildren().addAll(name, imageView);
        
         theater_index = 0;
        int X = 0;
        for (Theater theater1 : right_theat) {

            System.out.println(theater1);

            theat_index.add(theater_index);

            Button btn = new Button(theater1.getTime());
            btn.setLayoutX(250 + X);
            btn.setLayoutY(100);
            pane.getChildren().add(btn);

            if (theater1.getStatus().contains("SHOWING")) {
                btn.setStyle("-fx-border-color:blue");
                btn.setStyle("-fx-background-color:red");
                System.out.println("SHOWING WORK");
                btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        theater_index = theat_index.get(theater1.getId() - 1);
                        theater_id = theater1.getTheater_id();
                        System.out.println("theater1.getId() = " + theater_id);

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
                btn.setStyle("-fx-background-color:blue");
                System.out.println("DONE WORK");

            }

            System.out.println("theater_index = " + theater_index);
            theater_index++;

            X += 70;
        }
        
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
//        text.setStyle("-fx-font: 100px Tahoma");
//        text.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%)");
//        text.setStyle("-fx-stroke: black");
//        text.setStyle("-fx-stroke-width: 1");

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
        genre.setLayoutX(125);
        genre.setLayoutY(130);

        Label language = new Label("LANGUAGE: " + theat.get(0).getMovie().getLanguage());
        language.setLayoutX(125);
        language.setLayoutY(160);

        Image image = new Image(theat.get(0).getMovie().getImage(), 100, 150, false, true);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(13);
        imageView.setLayoutY(39);

        theater_index = 0;
        int X = 0;
        for (Theater theater1 : theat) {

            System.out.println(theater1);

            theat_index.add(theater_index);

            Button btn = new Button(theater1.getTime());
            btn.setLayoutX(250 + X);
            btn.setLayoutY(100);
            pane.getChildren().add(btn);

            if (theater1.getStatus().contains("SHOWING")) {
                btn.setStyle("-fx-border-color:blue");
                btn.setStyle("-fx-background-color:red");
                System.out.println("SHOWING WORK");
                btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        theater_index = theat_index.get(theater1.getId() - 1);
                        theater_id = theater1.getTheater_id();
                        System.out.println("theater1.getId() = " + theater_id);

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
                btn.setStyle("-fx-background-color:blue");
                System.out.println("DONE WORK");

            }

            System.out.println("theater_index = " + theater_index);
            theater_index++;

            X += 70;
        }
        System.out.println("-----------------");
        pane.getChildren().addAll(text, name, length, ratename, genre, language, imageView);

        return pane;
    }

    @FXML
    //cant take parametre in this method
    public void jump() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Theater.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        TheaterController controller = fxmlLoader.<TheaterController>getController();
//        controller.setTheaterID(Integer.parseInt(id));
        controller.setTheaterID(theater_id, theater_index);
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
