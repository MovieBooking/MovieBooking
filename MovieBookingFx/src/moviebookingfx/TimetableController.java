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
    
    @FXML
    private AnchorPane backpane;
    
    @FXML
    private AnchorPane anchor_scroll;
    
    @FXML
    private ScrollPane scrollpane;
    
    @FXML
    private Button btn1;
    
    int theater_id ;
    int theater_index;

    
    private List<Integer> theat_index = new ArrayList<Integer>(); 
//    private Theater theater;
    
//         ArrayList<Boolean> boolean_list = new ArrayList<Boolean>();
    private Movie movie_data;
    private List<Theater> theat = new ArrayList<Theater>();
    private List<Pane> movies = new ArrayList<Pane>();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-border-color:blue");
        gridpane.setMinSize(1200, 800);
        gridpane.setHgap(100);
        
        gridpane.getColumnConstraints().add(new ColumnConstraints(228));
        scrollpane.setContent(gridpane);
        
    
        
        DataService dataService = new DataService();
            

          for (int i = 1; i < 11; i++) {
            theat = dataService.getTheater(i);  
              
            movies.add(createPane(theat,i-1));
            
            gridpane.add(movies.get(i-1),0,i-1);
            
              System.out.println(i);
           
           }
            
       
        
        
        dataService.closeConnection();
        
//     String size,Movie movie,Screen screen, String time, int id, String status)
//        DataService dataService = new DataService();
//        theat = dataService.getTheater(1);
//       
//            Movie movie = new Movie("Justice Leauge", 120, "Action", "2016-11-23", "imageurl", 20,"ENG");
//            float X = 0;
//            float Y = 0;
//            int max = 0;
//            for (Theater theater1 : theat) {
//                if(theater1.getTheater_id() >= max)
//                {
//                   max =  theater1.getTheater_id();
//                }
//        
//                System.out.println("max = "+max);
//            }
//            for (int i = 0; i < max; i++) {
//             Pane temp = new Pane();
//             
//            Image image = new Image("/images/beyond-Skyline-poster.jpg",200,150,false,true);
//            ImageView imageView = new ImageView(image);    
//            imageView.setLayoutX(20);
//            imageView.setLayoutX(40);
//            
//            Text name = new Text();
//            Text screen = new Text();
//            Text dulation = new Text();
//            Text status = new Text();
//            name.setText("Name");
//            name.setText("screen");
//            name.setText("Name");
//            
//            
//            temp.setLayoutX(X);
//             temp.setLayoutY(Y+i*200);
//            temp.getChildren().add(imageView);
//            anchor.getChildren().add(temp);
//                 
//        
//                
//            }
//       
//      dataService.closeConnection();
    }   
    

    public Pane createPane(List<Theater> theat,int index)
    {
        Pane pane = new Pane();
        pane.minHeight(200);
        pane.minWidth(1200);
//        pane.setStyle("-fx-background-co");
        pane.setPadding(new Insets(10, 10, 10, 10));
        
        Label text = new Label("THETHER "+(index+1));
        text.setLayoutX(60);
        text.setLayoutY(10);
        text.setStyle("-fx-font: 100px Tahoma");
        text.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%)");
        text.setStyle("-fx-stroke: black");
         text.setStyle("-fx-stroke-width: 1");
        
        

        Label name = new Label("NAME:"+theat.get(0).getMovie().getName());
        name.setLayoutX(300);
        name.setLayoutY(40);
        
        Label length = new Label("DURATION:"+String.valueOf(theat.get(0).getMovie().getLength()));
        length.setLayoutX(300);
        length.setLayoutY(100);
        
        Label ratename = new Label("RATE:"+theat.get(0).getMovie().getRatename());
        ratename.setLayoutX(300);
        ratename.setLayoutY(160);
        
        Label genre = new Label("GENRE:"+theat.get(0).getMovie().getGenre());
        genre.setLayoutX(500);
        genre.setLayoutY(40);
        
        Label language = new Label("LANGUAGE:"+theat.get(0).getMovie().getLanguage());
        language.setLayoutX(500);
        language.setLayoutY(100);
          
        Image image = new Image(theat.get(0).getMovie().getImage(),200,150,false,true);
        ImageView imageView = new ImageView(image);   
        imageView.setLayoutX(20);
        imageView.setLayoutY(40);
        
        theater_index =0;
        int X = 0;
        for (Theater theater1 : theat) {
                   
        System.out.println(theater1);
        
         theat_index.add(theater_index);
        
        Button btn = new Button(theater1.getTime());
        btn.setLayoutX(800+X);
        btn.setLayoutY(100);
        pane.getChildren().add(btn);
       
        if(theater1.getStatus().contains("SHOWING"))
        {
             btn.setStyle("-fx-border-color:blue");
            btn.setStyle("-fx-background-color:red");
             System.out.println("SHOWING WORK");
             btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                  
           @Override
           public void handle(MouseEvent event)
                {     
                    theater_index = theat_index.get(theater1.getId()-1);
                    theater_id = theater1.getTheater_id();  
                    System.out.println("theater1.getId() = "+theater_id );
                    
              
//                 jump to another class
               try {
                   jump();
               } catch (IOException ex) {
                   Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
               }
               
                }
                });
        }
        else if(theater1.getStatus().contains("DONE"))
        {
            btn.setStyle("-fx-border-color:red");
            btn.setStyle("-fx-background-color:blue");
            System.out.println("DONE WORK");
        
        }
          
 
                //in MOVIE
                //done = cant press
                //showing = can
                
           System.out.println("theater_index = "+ theater_index); 
           theater_index++;
           
           X+= 70;
         }
        System.out.println("-----------------");
        
        
       
        
        pane.getChildren().addAll(text,name,length,ratename,genre,language,imageView);
        pane.setId("test");
        
        
                
                return pane;
    }
    
    @FXML
    //cant take parametre in this method
    public void jump() throws IOException 
    {
         
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Theater.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        
        TheaterController controller=fxmlLoader.<TheaterController>getController();
//        controller.setTheaterID(Integer.parseInt(id));
        controller.setTheaterID(theater_id,theater_index);
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
