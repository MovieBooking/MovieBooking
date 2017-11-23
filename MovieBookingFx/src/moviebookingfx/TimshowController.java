package moviebookingfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author PysiAz
 */
public class TimshowController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private ListView<String> listView;
     
    @FXML
    private ImageView pic;

    @FXML
    private Text movie_min;

    @FXML
    private Text movie_name;

    @FXML
    private Text movie_time;

    @FXML
    private Text movie_rate;

    @FXML
    private Text cinema1;

    @FXML
    private Text Lang1;

    @FXML
    private Text Screen1;

    @FXML
    private MenuButton btn1;

    @FXML
    private Text cinema2;

    @FXML
    private Text Lang2;

    @FXML
    private Text Screen2;

    @FXML
    private MenuButton btn2;

    @FXML
    private Text cinema3;

    @FXML
    private Text Lang3;

    @FXML
    private Text Screen3;

    @FXML
    private MenuButton btn3;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
        
         ObservableList<String> listViewData = FXCollections.observableArrayList();
          listViewData.add(new String("Lydia"));
          listViewData.add(new String("Anna"));
          listViewData.add(new String("Stefan"));
          listViewData.add(new String("Martin"));
        
        
        listView.setItems(listViewData);
    
           
        }    
}
