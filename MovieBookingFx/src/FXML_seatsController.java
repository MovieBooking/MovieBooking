

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author PysiAz
 */
public class FXML_seatsController implements Initializable {
    @FXML private Label label;
    @FXML private Button b1_1;
    @FXML private Button b1_2;
    @FXML private Button b1_3;
    @FXML private Button b1_4;
    @FXML private Button b1_5;
    @FXML private Button b1_6;
    @FXML private Button b1_7;
    @FXML private Button b1_8;
    @FXML private Button b1_9;
    @FXML private Button b1_10;
    @FXML private Button b1_11;
    @FXML private Button b1_12;
    @FXML private Button b1_13;
    @FXML private Button b1_14;
    @FXML private Button b1_15;
    @FXML
    private Button b2_1;

    @FXML
    private Button b2_2;

    @FXML
    private Button b2_3;

    @FXML
    private Button b2_4;

    @FXML
    private Button b2_5;

    @FXML
    private Button b2_6;

    @FXML
    private Button b2_7;

    @FXML
    private Button b2_8;

    @FXML
    private Button b2_9;

    @FXML
    private Button b2_10;

    @FXML
    private Button b2_11;

    @FXML
    private Button b2_12;

    @FXML
    private Button b2_13;

    @FXML
    private Button b2_14;

    @FXML
    private Button b2_15;
    
   
    Button[] btn = {b1_1,b1_2,b1_3,b1_4,b1_5};
  
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        // TODO
    
        
    

         
        
    }  
    
   
    public void onClick(MouseEvent event)
    {
       System.out.println(event.getX());
        System.out.println(event.getY());
       String text = ((Button)event.getSource()).getText();
       
        
        ((Button)event.getSource()).setStyle("fx-background-color: #FFF");
        
        System.out.println(((Button)event.getSource()).getId());
        System.out.println(text);
        for (int i = 0; i < 154; i++) {
             if(Integer.parseInt(text) == i)
             {
                 System.out.println("correct"+i);
             }
          
            
        }
       
        
//        
//        System.out.println("CLICKED"); 
//        int index = 0;
//        System.out.println(event.getButton());
//        System.out.println(event.getSource());
//        System.out.println(event.getTarget());
//        
//        if(btn[index]==event.getSource())
//        {
//            System.out.println("dai leaw");
//        }
//        else System.out.println("mai dai");
//        
        
    }
    public void vipClick()
    {
      
    
        System.out.println("VIPCLICK");
        
    }
    
    
            
    
}


