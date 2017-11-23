package moviebookingfx;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Class.SmallTheater;
import Class.ThreeDimensionScreen;
import Class.Seats;
import Class.Theater;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PysiAz
 */
public class FXML_seats_L_Controller implements Initializable {
    Theater z;
    @FXML
    private AnchorPane rootPane;
    @FXML private Label label;
    
    @FXML private Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20;
    @FXML private Button a21,a22,a23,a24,a25,a26,a27,a28,a29,a30,a31,a32,a33,a34,a35,a36,a37,a38,a39,a40; 
    @FXML private Button a41,a42,a43,a44,a45,a46,a47,a48,a49,a50,a51,a52,a53,a54,a55,a56,a57,a58,a59,a60; 
    @FXML private Button a61,a62,a63,a64,a65,a66,a67,a68,a69,a70,a71,a72,a73,a74,a75,a76,a77,a78,a79,a80;
    @FXML private Button a81,a82,a83,a84,a85,a86,a87,a88,a89,a90,a91,a92,a93,a94,a95,a96,a97,a98,a99,a100;
    @FXML private Button a101,a102,a103,a104,a105,b106,b107,b108,b109,b110,b111,b112,b113,b114,b115,b116,b117,b118,b119,b120;
   
//   
//    Button[] btn = {a1,a2,a3,a4,a5};
//    
    int n = 7*15;
    Seats[] a = new Seats[n];
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        // TODO
        
//    int n = 7*15;
////    Seats(String position,long theater_id)
//    Seats[] a = new Seats[n];


    //screen screen, String time, int id, String status
        Theater z = new SmallTheater(new ThreeDimensionScreen(3),"11.00",3,"SHOWING");
    
        System.out.println(z.getSeats().get(0).get(0).toString());
        System.out.println(z.getSeats().get(0).get(3).toString());
        System.out.println(z.getSeats().get(1).get(0).toString());
        
        
//         for (int i = 0; i < n; i++) {
//             a[i] = new NormalSeats("a"+i,i);
//             a[i].setIsBook(false);
//            System.out.println(a[i].getName());
//            System.out.println(a[i].getPosition());
    }  
 
   
    public void onClick(MouseEvent event)
    {
//       System.out.println(event.getX());
//        System.out.println(event.getY());
        
       String text = ((Button)event.getSource()).getText();
       String id = ((Button)event.getSource()).getId();
       String row,col;
        System.out.println("button Id :"+id);
        System.out.println("text id :"+text);
        
        row = id.substring(0,1);
        col = id.substring(1);
        System.out.println("row"+ row +"col"+ col);
       
       
//        for (int i = 0; i < 10-1; i++) {
//            for (int j = 0; j < 15-1; j++) {
//                
//            
//                if(  id == z.getSeats().get(i).get(j).getPosition())
//                {
//                    System.out.println("isBook : "+z.getSeats().get(0).get(0).getIsBook());
//
//                       if( z.getSeats().get(0).get(0).getIsBook()==false)
//                    {
//
//                        ((Button)event.getSource()).setStyle("-fx-border-color:  #1D1E1F;-fx-background-color: #b6e7c9;-fx-font: 15 arial; -fx-base: #b6e7c9;");
//   //                     System.out.println("correct"+i);
//                         a[i].setIsBook(true);
//                         System.out.println("CHANGE1");
//
//                    }
//                       else
//                    {
//                        ((Button)event.getSource()).setStyle("-fx-border-color:  #1D1E1F;-fx-background-color: #EA3900;-fx-font: 15 arial; -fx-base: #EA3900;");
//                       a[i].setIsBook(false);
//                       System.out.println("CHANGE2");
//                    }
//
//                       System.out.println("boolean : "+a[i].getIsBook());
//                       break;
//                }
//            }
//            
//        }
        System.out.println("=======================");
       
        
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
    @FXML
    public void submit(ActionEvent event) throws IOException 
    {
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("FXML_seats_1.fxml"));
//        /* 
//         * if "fx:controller" is not set in fxml
//         * fxmlLoader.setController(NewWindowController);
//         */
//        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
//        Stage stage = new Stage();
//        stage.setTitle("New Window");
//        stage.setScene(scene);
//        stage.show(); 


       
        
    }
    
            
    
}


