

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
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
import moviebookingfx.*;

/**
 * FXML Controller class
 *
 * @author PysiAz
 */

public class FXML_seatsController implements Initializable {
    
    Theater z;
    
    ArrayList<String> position_list  = new ArrayList<String>();
    ArrayList<Boolean> boolean_list = new ArrayList<Boolean>();
    
    String[] money;
    @FXML
    private AnchorPane rootPane;
    @FXML private Label label;
    @FXML private Button V1,V2,V3,V4;
    @FXML private Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;
    @FXML private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    @FXML private Button c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
    @FXML private Button d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15;
    @FXML private Button e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15;
    @FXML private Button f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15;
    @FXML private Button g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14,g15;
    @FXML private Button h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13,h14,h15;
    @FXML private Button i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15;
 
   
//   
//    Button[] btn = {a1,a2,a3,a4,a5};
//    
    int n = 7*15;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        // TODO
       
//       ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
       
        
    
        
        
        
//    int n = 7*15;
////    Seats(String position,long theater_id)
//    Seats[] a = new Seats[n];

    //screen screen, String time, int id, String status
        this.z = new SmallTheater(new ThreeDimensionScreen(3),"11.00",3,"SHOWING");
    
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
   
       
  
        
//       row 1
        for(int v = 0;v<4;v++) //deluxe seats
        {
            if( id.equals(z.getSeats().get(0).get(v).getPosition()))       
            {
                
                System.out.println("11111111111");  
                
                 if( z.getSeats().get(0).get(v).getIsBook()==false)
                    {
                        for (int i = 0; i < 5; i++) {
                                if(position_list.get(i).equals(z.getSeats().get(0).get(v).getPosition()))                
                                {
                                    position_list.remove(i);
                                    boolean_list.remove(i);
                                     ((Button)event.getSource()).setStyle("-fx-border-color:  #1D1E1F;-fx-background-color: #b6e7c9;-fx-font: 15 arial; -fx-base: #b6e7c9;");
                                }
                                else
                                {
                                    position_list.add( z.getSeats().get(0).get(v).getPosition());
                                    boolean_list.add(false);
                                     ((Button)event.getSource()).setStyle("-fx-border-color:  #1D1E1F;-fx-background-color: #EF2AFF;-fx-font: 15 arial; -fx-base: #EF2AFF;");
                                                        
                                }               
           
                             System.out.println("CHANGE1");
                             System.out.println(position_list+"  \n"+boolean_list);
                         
                           
                         
             
                          
                        }

                    }
                       else //cant change booking
                    {
                        System.out.println("CANT BOOKING");
                    }            
                       break;
       
      
            }
            
        }
        System.out.println("HERE");
//        row 2-11
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 15; j++) {
                
                if(  id.equals(z.getSeats().get(i).get(j).getPosition()) )
                {
                  System.out.println("FOUND");   
                  if(i<4)   //normal seats
                  {
                       if( z.getSeats().get(i).get(j).getIsBook()==false)
                    {

                        ((Button)event.getSource()).setStyle("-fx-border-color:  #1D1E1F;-fx-background-color: #b6e7c9;-fx-font: 15 arial; -fx-base: #b6e7c9;");
   //                     System.out.println("correct"+i);
                         z.getSeats().get(i).get(j).setIsBook(true);
                         System.out.println("CHANGE1");
                            this.position_list.add("V1");
                            boolean_list.add(false);

                    }
                       else
                    {
                        ((Button)event.getSource()).setStyle("-fx-border-color:  #1D1E1F;-fx-background-color: #4991EF;-fx-font: 15 arial; -fx-base: #4991EF;");
                       z.getSeats().get(i).get(j).setIsBook(false);
                       System.out.println("CHANGE2");
                    }
              
                       break;
                  }
                  else //honeymoon seats
                  {
                        if( z.getSeats().get(i).get(j).getIsBook()==false)
                    {

                        ((Button)event.getSource()).setStyle("-fx-border-color:  #1D1E1F;-fx-background-color: #b6e7c9;-fx-font: 15 arial; -fx-base: #b6e7c9;");
   //                     System.out.println("correct"+i);
                         z.getSeats().get(i).get(j).setIsBook(true);
                         System.out.println("CHANGE1");

                    }
                       else
                    {
                        ((Button)event.getSource()).setStyle("-fx-border-color:  #1D1E1F;-fx-background-color: #EA3900;-fx-font: 15 arial; -fx-base: #EA3900;");
                       z.getSeats().get(i).get(j).setIsBook(false);
                       System.out.println("CHANGE2");
                    }

                       System.out.println("boolean : ");
                       break;
                  }
                      
                }
            }
            
        }
        System.out.println("=======================");
       
        
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


