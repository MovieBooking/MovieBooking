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
import javafx.scene.text.Text;
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
  
    private Theater theater;
    
//         ArrayList<Boolean> boolean_list = new ArrayList<Boolean>();
    
    
    private List<Theater> theat = new ArrayList<Theater>();
    private List<Pane> movies = new ArrayList<Pane>();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-border-color:blue;");
        gridpane.setMinSize(1200, 800);
        gridpane.setHgap(100);
        
        gridpane.getColumnConstraints().add(new ColumnConstraints(228));
        scrollpane.setContent(gridpane);
        
        DataService dataService = new DataService();
 

//            for (int i = 1; i < 10 ; i++) {
              theat = dataService.getTheater(1);  
              
              movies.add(createPane(theat,1));
            
            gridpane.add(movies.get(0),0,1);
           
//           }
            
       
        
        
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
        
        Label name = new Label(theat.get(0).getMovie().getName());
        name.setLayoutX(300);
        name.setLayoutY(40);
        
        Label length = new Label(String.valueOf(theat.get(0).getMovie().getLength()));
        length.setLayoutX(300);
        length.setLayoutY(100);
        
        Label ratename = new Label(theat.get(0).getMovie().getRatename());
        ratename.setLayoutX(300);
        ratename.setLayoutY(160);
        
        Label genre = new Label(theat.get(0).getMovie().getGenre());
        genre.setLayoutX(500);
        genre.setLayoutY(40);
        
        Label language = new Label(theat.get(0).getMovie().getLanguage());
        language.setLayoutX(500);
        language.setLayoutY(100);
          
        Image image = new Image(theat.get(0).getMovie().getImage(),200,150,false,true);
        ImageView imageView = new ImageView(image);   
        imageView.setLayoutX(20);
        imageView.setLayoutY(40);
        
        int X = 0;
        for (Theater theater1 : theat) {
         
            System.out.println(theater1);
        Button btn = new Button(theater1.getTime());
        btn.setLayoutX(800+X);
        btn.setLayoutY(100);
        pane.getChildren().add(btn);
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                  
           @Override
           public void handle(MouseEvent event)
                {
                    System.out.println(" btn is pressed!!");
                }
                });
        
            X+= 200;
        
         }
        
       
        
        pane.getChildren().addAll(name, length,ratename,genre,language,imageView);
        pane.setId("test");
        
        
                
                return pane;
    }
    
    @FXML
    public void jump() throws IOException
    {
          try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Theater.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        
        TheaterController controller=fxmlLoader.<TheaterController>getController();
//        controller.setUser(Integer.parseInt("3"));
//        controller.setting();
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
